package super_entidades

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class UtilizadorController {

    UtilizadorService utilizadorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond utilizadorService.list(params), model:[utilizadorCount: utilizadorService.count()]
    }

    def show(Long id) {
        respond utilizadorService.get(id)
    }

    def create() {
        respond new Utilizador(params)
    }

    def save(Utilizador utilizador) {
        if (utilizador == null) {
            notFound()
            return
        }

        try {
            utilizadorService.save(utilizador)
        } catch (ValidationException e) {
            respond utilizador.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'utilizador.label', default: 'Utilizador'), utilizador.id])
                redirect utilizador
            }
            '*' { respond utilizador, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond utilizadorService.get(id)
    }

    def update(Utilizador utilizador) {
        if (utilizador == null) {
            notFound()
            return
        }

        try {
            utilizadorService.save(utilizador)
        } catch (ValidationException e) {
            respond utilizador.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'utilizador.label', default: 'Utilizador'), utilizador.id])
                redirect utilizador
            }
            '*'{ respond utilizador, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        utilizadorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'utilizador.label', default: 'Utilizador'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'utilizador.label', default: 'Utilizador'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
