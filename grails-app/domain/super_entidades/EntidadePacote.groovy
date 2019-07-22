package super_entidades

class EntidadePacote {

    Entidade entidade
    Pacote pacote
    Date dataInicio
    Date dataValidade
    Date dataRegisto, dataModif


    static hasMany = [auditoria:Auditoria]
    static belongsTo = [entidade:Entidade, pacote:Pacote]
    static constraints = {
    }
}
