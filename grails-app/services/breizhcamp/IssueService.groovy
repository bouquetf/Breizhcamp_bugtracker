package breizhcamp

import javax.security.auth.login.LoginContext
import org.ow2.bonita.util.SimpleCallbackHandler
import org.ow2.bonita.facade.RuntimeAPI
import org.ow2.bonita.util.AccessorUtil
import org.ow2.bonita.facade.uuid.ProcessDefinitionUUID
import org.ow2.bonita.facade.uuid.ProcessInstanceUUID
import org.ow2.bonita.facade.QueryRuntimeAPI
import org.ow2.bonita.facade.uuid.ActivityInstanceUUID

class IssueService {

    def serviceMethod() {

    }
    def startProcess(String user, Issue issue, def variables) {
        LoginContext loginContext = new LoginContext("BonitaStore", new SimpleCallbackHandler(user,""));
        loginContext.login();

        RuntimeAPI runtimeAPI = AccessorUtil.getRuntimeAPI();

        ProcessDefinitionUUID processDefinitionUUID = new ProcessDefinitionUUID("Suivi_d_issue","1.0");
        HashMap<String, Object> parametres = new HashMap<String, Object>();
        variables.each {
            parametres.put(it, issue."${it}");
        }

        ProcessInstanceUUID processInstanceUUID = runtimeAPI.instantiateProcess(processDefinitionUUID, parametres);
        loginContext.logout();

        issue.ident = processInstanceUUID.getValue()
        issue.save(flush: true)
    }

    def ChangeEtat(String user, Issue issue, String nomTache, String etat, Map<String, String> variables) {
        LoginContext loginContext = new LoginContext("BonitaStore", new SimpleCallbackHandler(user,""));
        loginContext.login();
        RuntimeAPI runtimeAPI = AccessorUtil.getRuntimeAPI();
        QueryRuntimeAPI queryRuntimeAPI = AccessorUtil.getQueryRuntimeAPI()

        ActivityInstanceUUID activityInstanceUUID =
            queryRuntimeAPI.getActivityInstances(new ProcessInstanceUUID(issue.ident), nomTache)
                    .toArray()[0].getUUID()
        runtimeAPI.startTask(activityInstanceUUID, true)
        issue.setEtat(etat)
        issue.setProperties(variables)
        issue.save(flush: true)
        if (!variables.isEmpty()) {
            HashMap<String, Object> parametres = new HashMap<String, Object>()
            variables.each {
                parametres.put(it.key, it.value)
            }
            runtimeAPI.setProcessInstanceVariables(new ProcessInstanceUUID(issue.ident), parametres)
        }

        runtimeAPI.finishTask(activityInstanceUUID, true)

        loginContext.logout();
    }
}
