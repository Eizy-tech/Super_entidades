package super_entidades

class ContactoMsg {

    String nome
    String celular
    String email
    String assunto
    String mensagem
    Entidade entidade
    Date dataEnvio

    static belongsTo = [entidade: Entidade]
    static constraints = {
        nome(maxSize: 100)
        email(maxSize: 100)
    }
    static mapping = {
        mensagem type: "text"
    }
}