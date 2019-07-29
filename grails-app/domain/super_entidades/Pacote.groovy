package super_entidades

class Pacote {

    String descricao
    String estado
    Double preco
    Date dataRegisto, dataModif


    static hasMany = [entidadePacote: EntidadePacote]
    static constraints = {
        descricao(nullable:false,blank:false)
        estado(nullable: false,blank:false)
        preco(nullable: false,blank:false)
    }

















}