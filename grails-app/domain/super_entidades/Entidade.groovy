package super_entidades

class Entidade {

    String nome, descricao, slogan, telefone, fax, celular, email, website, logo, endereco, estado
    Double latitude, longitude
    Boolean activo = true
    Date dataRegisto, dataModif
    Utilizador utilizadorRegisto, utilizadorModif

    static hasMany = [vagas: Vaga, portifolios:PortifolioItem, entidadePacote: EntidadePacote, contactoMsg:ContactoMsg]
    static belongsTo = [categoria: CategoriaEntidade]

    static constraints = {
        nome(maxSize: 100)
        slogan(nullable: true, maxSize: 100)
        telefone(nullable: true)
        fax(nullable: true,unique: true)
        celular(nullable: true,unique: true)
        email(nullable: true, maxSize: 250,unique: true)
        website(nullable: true, maxSize: 250)
        logo(nullable: true, maxSize: 100)
        estado(nullable: true)
        latitude(nullable: true)
        longitude(nullable: true)
        dataRegisto()
    }

    static mapping = {
        descricao type:  "text"
        endereco type: "text"
    }
}