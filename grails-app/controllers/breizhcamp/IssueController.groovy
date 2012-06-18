package breizhcamp

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
        redirect(action: "aresoudre")
    }

    def aevaluer() {
        [issueList: Issue.findAllByEtat("AEVALUER")]
    }

    def evaluer() {
        [issue: Issue.findById(params.id)]
    }

    def valider_evaluation() {
        issueService.changeEtatIssue(params, 'AASSIGNER')
        redirect(action: 'aresoudre')
    }

    def refuser_evaluation() {
        issueService.changeEtatIssue(params, 'REFUSEE')
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
        issue.setDeveloppeur(params.developpeur)
        issue.setEtat('ARESOUDRE')
        issue.save(flush: true)
        redirect(action: 'aresoudre')
    }

    def aresoudre() {
        [issueList: Issue.findAllByEtat("ARESOUDRE")]
    }

    def resoudre() {
        [issue: Issue.findById(params.id)]
    }

    def soumettre_resoudre() {
        issueService.changeEtatIssue(params, 'RESOLUE')
        redirect(action: 'aresoudre')
    }
}
