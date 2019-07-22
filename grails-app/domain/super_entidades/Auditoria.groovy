package super_entidades

class Auditoria {

    Entidade entidade
    Pacote pacote
    Date dataRegisto, dataModif

    static belongsTo = [entidade:Entidade, pacote: Pacote]

    static constraints = {
    }
}
