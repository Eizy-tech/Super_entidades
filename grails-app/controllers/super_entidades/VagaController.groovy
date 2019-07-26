package super_entidades

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['ROLE_ADMIN' , 'ROLE_USER'])

class VagaController {

    VagaService vagaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def springSecurityService
    def utilizadorLogado(){
        def utilizador = (Utilizador)springSecurityService.currentUser
        return utilizador
    }

    // Metodo para adicionar vaga
    // Somente utilizador autorizado

    @Secured(['ROLE_ADMIN' , 'ROLE_USER'])
    def salvar(Vaga vaga){

        vaga.setDataRegisto(new Date())
        vaga.setDataModif(new Date())
        vaga.setEntidade() // faltam atributos do utilizador logado

        vaga.utilizadorRegisto = utilizadorLogado()
        vaga.utilizadorModif = utilizadorLogado()

        def msg = [:]
        try {
            vagaService.save(vaga)
            msg ['msg'] = "Publicacao Feita com Sucesso"
            msg['vaga'] = Vaga
        }
        catch (ValidationException e){
            msg ['msg'] = "Error:" + e.getMessage()
        }
        render msg as JSON
    }


    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vagaService.list(params), model:[vagaCount: vagaService.count()]
    }

    def show(Long id) {
        respond vagaService.get(id)
    }

    def create() {
        respond new Vaga(params)

    }

    def save(Vaga vaga) {
        if (vaga == null) {
            notFound()
            return
        }

        try {
            vagaService.save(vaga)
        } catch (ValidationException e) {
            respond vaga.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vaga.label', default: 'Vaga'), vaga.id])
                redirect vaga
            }
            '*' { respond vaga, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vagaService.get(id)
    }

    def update(Vaga vaga) {
        if (vaga == null) {
            notFound()
            return
        }

        try {
            vagaService.save(vaga)
        } catch (ValidationException e) {
            respond vaga.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vaga.label', default: 'Vaga'), vaga.id])
                redirect vaga
            }
            '*'{ respond vaga, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vagaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vaga.label', default: 'Vaga'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vaga.label', default: 'Vaga'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
