package super_entidades

class CategoriaEntidade {

    String descricao
    boolean activo = true
    Date dataRegisto, dataModif

    static hasMany = [entidade: Entidade]
    static constraints = {

    }
}
