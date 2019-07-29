package super_entidades

class CategoriaVaga {
    String descricao
    String estado
    Date dataRegisto, dataModif
    Utilizador utilizadorRegisto, utilizadorModif


    static hasMany = [vagas:Vaga]
    static constraints = {
    }
}
