package super_entidades

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['ROLE_ADMIN' , 'ROLE_USER']) // Somente utilizador autorizado
class PacoteController {

    PacoteService pacoteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]6666


    //Metodo para adicionar um pacote
    def salvar(Pacote pacote){
        def msg=[:]
        pacote.setDataRegisto(new Date())
        pacote.setDataModif(new Date())

        try {
            pacoteService.save(pacote)
            msg['msg'] = "Salvo com Sucesso"
            msg['pacote'] = pacote
        } catch (ValidationException e) {
            msg['msg'] = "Erro: " + e.getMessage() + "\n contacte o tecnico."
//            if(pacote.errors.hasFieldErrors('descricao')) {
//                msg['msg'] = "Erro: " + e.getMessage() + "\n contacte o tecnico."
//            }
        }
        render msg as JSON
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond pacoteService.list(params), model:[pacoteCount: pacoteService.count()]
    }

    def show(Long id) {
        respond pacoteService.get(id)
    }

    def create() {
        respond new Pacote(params)
    }

    def edit(Long id) {
        respond pacoteService.get(id)
    }

    def update(Pacote pacote) {
        if (pacote == null) {
            notFound()
            return
        }

        try {
            pacoteService.save(pacote)
        } catch (ValidationException e) {
            respond pacote.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pacote.label', default: 'Pacote'), pacote.id])
                redirect pacote
            }
            '*'{ respond pacote, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        pacoteService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pacote.label', default: 'Pacote'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pacote.label', default: 'Pacote'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
