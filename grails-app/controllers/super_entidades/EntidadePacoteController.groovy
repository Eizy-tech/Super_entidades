package super_entidades

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EntidadePacoteController {

    EntidadePacoteService entidadePacoteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond entidadePacoteService.list(params), model:[entidadePacoteCount: entidadePacoteService.count()]
    }

    def show(Long id) {
        respond entidadePacoteService.get(id)
    }

    def create() {
        respond new EntidadePacote(params)
    }

    def save(EntidadePacote entidadePacote) {
        if (entidadePacote == null) {
            notFound()
            return
        }

        try {
            entidadePacoteService.save(entidadePacote)
        } catch (ValidationException e) {
            respond entidadePacote.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'entidadePacote.label', default: 'EntidadePacote'), entidadePacote.id])
                redirect entidadePacote
            }
            '*' { respond entidadePacote, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond entidadePacoteService.get(id)
    }

    def update(EntidadePacote entidadePacote) {
        if (entidadePacote == null) {
            notFound()
            return
        }

        try {
            entidadePacoteService.save(entidadePacote)
        } catch (ValidationException e) {
            respond entidadePacote.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'entidadePacote.label', default: 'EntidadePacote'), entidadePacote.id])
                redirect entidadePacote
            }
            '*'{ respond entidadePacote, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        entidadePacoteService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'entidadePacote.label', default: 'EntidadePacote'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'entidadePacote.label', default: 'EntidadePacote'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
