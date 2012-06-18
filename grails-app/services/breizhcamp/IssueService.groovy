package breizhcamp

class IssueService {

    def changeEtatIssue(def params, def etat) {
        def issue = Issue.findById(params.id)
        issue.setEtat(etat)
        issue.save(flush: true)
    }
}
