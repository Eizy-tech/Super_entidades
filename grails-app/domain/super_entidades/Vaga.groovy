package super_entidades

class Vaga {
    String cargo
    String funcoes
    String local
    String requisitos
    Date dataRegisto
    Date dataValidade
    Date dataModif
    String estado
    Entidade entidade
    CategoriaVaga categoria
    Utilizador utilizadorRegisto, utilizadorModif


    static belongsTo = [entidade:Entidade,categoria:CategoriaVaga]

    static constraints = {
        funcoes(nullable: true)
        local(nullable: true)
    }
}
