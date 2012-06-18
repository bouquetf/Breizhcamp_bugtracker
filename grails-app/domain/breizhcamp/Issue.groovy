package breizhcamp

class Issue {
    String ident
    String titre
    String description
    String etat
    String developpeur
    String demandeur
    String criticite

    static constraints = {
        demandeur(blank: false, email: true)
        titre(blank: false)
        description(blank: false)
        etat(blank: true, nullable: true)
        ident(blank: true, nullable: true)
        developpeur(blank: true, nullable: true)
        criticite(blank: true, nullable: true)
    }
}
