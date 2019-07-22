package super_entidades

class Visita {

    String dispositivo
    Double localizacao
    Date data
    Auditoria auditoria
    Date dataRegisto, dataModif

    static belongsTo = [auditoria: Auditoria]

    static constraints = {
    }
}
