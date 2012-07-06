package breizhcamp

import org.ow2.bonita.facade.QueryRuntimeAPI
import org.ow2.bonita.facade.RuntimeAPI
import org.ow2.bonita.facade.uuid.ActivityInstanceUUID
import org.ow2.bonita.facade.uuid.ProcessDefinitionUUID
import org.ow2.bonita.facade.uuid.ProcessInstanceUUID
import org.ow2.bonita.util.AccessorUtil
import org.ow2.bonita.util.SimpleCallbackHandler

import javax.security.auth.login.LoginContext

class IssueController {
    def scaffold = true

    def index() {
        redirect(action: "aresoudre", params: params)
    }

    def nouvelle_issue() {
    }

    def soumettre_nouvelle_issue() {
        def issue = new Issue(params + [etat: 'AEVALUER'])
        if (!issue.save(flush: true)) {
            render(view: 'nouvelle_issue', model: [issue: issue])
            return
        }

        LoginContext loginContext = new LoginContext("BonitaStore", new SimpleCallbackHandler("admin",""));
        loginContext.login();
        RuntimeAPI runtimeAPI = AccessorUtil.getRuntimeAPI();
        ProcessDefinitionUUID processDefinitionUUID = new ProcessDefinitionUUID("Suivi_d_issue","1.0");
        HashMap<String, Object> parametres = new HashMap<String, Object>();
        parametres.put('demandeur', issue.demandeur);
        ProcessInstanceUUID processInstanceUUID = runtimeAPI.instantiateProcess(processDefinitionUUID, parametres);
        loginContext.logout();

        issue.ident = processInstanceUUID.getValue()
        issue.save(flush: true)

        redirect(action: "aresoudre")
    }

    def aevaluer() {
        [issueList: Issue.findAllByEtat("AEVALUER")]
    }

    def evaluer() {
        [issue: Issue.findById(params.id)]
    }

    def valider_evaluation() {
        def issue = Issue.findById(params.id)

        LoginContext loginContext = new LoginContext("BonitaStore", new SimpleCallbackHandler("admin",""));
        loginContext.login();
        RuntimeAPI runtimeAPI = AccessorUtil.getRuntimeAPI();
        QueryRuntimeAPI queryRuntimeAPI = AccessorUtil.getQueryRuntimeAPI()

        ActivityInstanceUUID activityInstanceUUID =
            queryRuntimeAPI.getActivityInstances(new ProcessInstanceUUID(issue.ident), 'Evaluer_la_criticite')
                    .toArray()[0].getUUID()
        runtimeAPI.startTask(activityInstanceUUID, true)
        issue.setEtat('AASSIGNER')
        issue.save(flush: true)
        runtimeAPI.setProcessInstanceVariable(new ProcessInstanceUUID(issue.ident), 'decision', 'Oui')
        runtimeAPI.finishTask(activityInstanceUUID, true)
        loginContext.logout();

        redirect(action: 'aresoudre')
    }

    def refuser_evaluation() {
        def issue = Issue.findById(params.id)

        LoginContext loginContext = new LoginContext("BonitaStore", new SimpleCallbackHandler("admin",""));
        loginContext.login();
        RuntimeAPI runtimeAPI = AccessorUtil.getRuntimeAPI();
        QueryRuntimeAPI queryRuntimeAPI = AccessorUtil.getQueryRuntimeAPI()
        ActivityInstanceUUID activityInstanceUUID =
            queryRuntimeAPI.getActivityInstances(new ProcessInstanceUUID(issue.ident), 'Evaluer_la_criticite')
                    .toArray()[0].getUUID()
        runtimeAPI.startTask(activityInstanceUUID, true)
        issue.setEtat('REFUSEE')
        issue.save(flush: true)
        runtimeAPI.setProcessInstanceVariable(new ProcessInstanceUUID(issue.ident), 'decision', 'Non')
        runtimeAPI.finishTask(activityInstanceUUID, true)
        loginContext.logout();

        redirect(action: 'aresoudre')
    }

    def aassigner() {
        [issueList: Issue.findAllByEtat("AASSIGNER")]
    }

    def assigner() {
        [issue: Issue.findById(params.id)]
    }

    def soumettre_assigner() {
        def issue = Issue.findById(params.id)

        LoginContext loginContext = new LoginContext("BonitaStore", new SimpleCallbackHandler("admin",""));
        loginContext.login();
        RuntimeAPI runtimeAPI = AccessorUtil.getRuntimeAPI();
        QueryRuntimeAPI queryRuntimeAPI = AccessorUtil.getQueryRuntimeAPI()
        ActivityInstanceUUID activityInstanceUUID =
            queryRuntimeAPI.getActivityInstances(new ProcessInstanceUUID(issue.ident), 'Affecter_un_developpeur')
                    .toArray()[0].getUUID()
        runtimeAPI.startTask(activityInstanceUUID, true)
        issue.setDeveloppeur(params.developpeur)
        issue.setEtat('ARESOUDRE')
        issue.save(flush: true)
        runtimeAPI.setProcessInstanceVariable(new ProcessInstanceUUID(issue.ident), 'developpeur', issue.developpeur)
        runtimeAPI.finishTask(activityInstanceUUID, true)
        loginContext.logout();

        redirect(action: 'aresoudre')
    }

    def aresoudre() {
        [issueList: Issue.findAllByEtat("ARESOUDRE")]
    }

    def resoudre() {
        [issue: Issue.findById(params.id)]
    }

    def soumettre_resoudre() {
        def issue = Issue.findById(params.id)

        LoginContext loginContext = new LoginContext("BonitaStore", new SimpleCallbackHandler("admin",""));
        loginContext.login();
        RuntimeAPI runtimeAPI = AccessorUtil.getRuntimeAPI();
        QueryRuntimeAPI queryRuntimeAPI = AccessorUtil.getQueryRuntimeAPI()
        ActivityInstanceUUID activityInstanceUUID =
            queryRuntimeAPI.getActivityInstances(new ProcessInstanceUUID(issue.ident), 'Resoudre_l_issue')
                    .toArray()[0].getUUID()
        runtimeAPI.startTask(activityInstanceUUID, true)
        issue.setDeveloppeur(params.developpeur)
        issue.setEtat('RESOLUE')
        issue.save(flush: true)
        runtimeAPI.finishTask(activityInstanceUUID, true)
        loginContext.logout();

        redirect(action: 'aresoudre')
    }
}
