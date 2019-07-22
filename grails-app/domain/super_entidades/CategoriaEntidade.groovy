package super_entidades

class CategoriaEntidade {

    String descricao
    String estado
    Date dataRegisto, dataModif

    static hasMany = [entidade: Entidade]
    static constraints = {
    }
}
