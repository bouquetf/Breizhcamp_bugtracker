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
    def issueService

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

        issueService.startProcess('admin', issue, ['demandeur'])

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

        issueService.ChangeEtat('admin',issue, 'Evaluer_la_criticite', 'AASSIGNER', [decision:'Oui'])

        redirect(action: 'aresoudre')
    }

    def refuser_evaluation() {
        def issue = Issue.findById(params.id)

        issueService.ChangeEtat('admin', issue, 'Evaluer_la_criticite', 'REFUSEE', [decision: 'Non'])

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

        issueService.ChangeEtat('admin', issue, 'Affecter_un_developpeur', 'ARESOUDRE',
                [developpeur: params.developpeur])

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

        issueService.ChangeEtat('admin', issue, 'Resoudre_l_issue', 'RESOLUE', [:])

        redirect(action: 'aresoudre')
    }
}
