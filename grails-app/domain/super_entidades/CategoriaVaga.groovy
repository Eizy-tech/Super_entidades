package super_entidades

class CategoriaVaga {
    String descricao
    String estado
    Date dataRegisto, dataModif


    static hasMany = [vagas:Vaga]
    static constraints = {
    }
}
