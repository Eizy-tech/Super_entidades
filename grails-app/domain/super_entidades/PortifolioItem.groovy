package super_entidades

class PortifolioItem {

    String descricao
    String imagem
    String estado
    Entidade entidade
    Date dataRegisto, dataModif

    static belongsTo = [entidade:Entidade]
    static constraints = {
        imagem(nullable: true)
    }
}
