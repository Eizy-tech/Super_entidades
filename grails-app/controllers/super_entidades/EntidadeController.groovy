package super_entidades

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured(['ROLE_ADMIN' , 'ROLE_USER'])

class EntidadeController {

    EntidadeService entidadeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond entidadeService.list(params), model:[entidadeCount: entidadeService.count()]
    }

    def show(Long id) {
        respond entidadeService.get(id)
    }

    def create() {
        respond new Entidade(params)
    }

    def save(Entidade entidade) {
        if (entidade == null) {
            notFound()
            return
        }

        try {
            entidadeService.save(entidade)
        } catch (ValidationException e) {
            respond entidade.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'entidade.label', default: 'Entidade'), entidade.id])
                redirect entidade
            }
            '*' { respond entidade, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond entidadeService.get(id)
    }

    def update(Entidade entidade) {
        if (entidade == null) {
            notFound()
            return
        }

        try {
            entidadeService.save(entidade)
        } catch (ValidationException e) {
            respond entidade.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'entidade.label', default: 'Entidade'), entidade.id])
                redirect entidade
            }
            '*'{ respond entidade, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        entidadeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'entidade.label', default: 'Entidade'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'entidade.label', default: 'Entidade'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
