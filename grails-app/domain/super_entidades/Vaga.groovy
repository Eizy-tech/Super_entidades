package super_entidades

class Vaga {
    String cargo
    String funcoes
    String local
    String requisitos
    Date data_publicacao
    Date data_validade
    String estado
    Entidade entidade
    CategoriaVaga categoria
    Date dataRegisto, dataModif

    static belongsTo = [entidade:Entidade,categoria:CategoriaVaga]

    static constraints = {
        funcoes(nullable: true)
        local(nullable: true)
    }
}
