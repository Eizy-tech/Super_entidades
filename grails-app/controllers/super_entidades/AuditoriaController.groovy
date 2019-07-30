package super_entidades

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AuditoriaController {

    AuditoriaService auditoriaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond auditoriaService.list(params), model:[auditoriaCount: auditoriaService.count()]
    }

    def show(Long id) {
        respond auditoriaService.get(id)
    }

    def create() {
        respond new Auditoria(params)
    }

    def save(Auditoria auditoria) {
        if (auditoria == null) {
            notFound()
            return
        }

        try {
            auditoriaService.save(auditoria)
        } catch (ValidationException e) {
            respond auditoria.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'auditoria.label', default: 'Auditoria'), auditoria.id])
                redirect auditoria
            }
            '*' { respond auditoria, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond auditoriaService.get(id)
    }

    def update(Auditoria auditoria) {
        if (auditoria == null) {
            notFound()
            return
        }

        try {
            auditoriaService.save(auditoria)
        } catch (ValidationException e) {
            respond auditoria.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'auditoria.label', default: 'Auditoria'), auditoria.id])
                redirect auditoria
            }
            '*'{ respond auditoria, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        auditoriaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'auditoria.label', default: 'Auditoria'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'auditoria.label', default: 'Auditoria'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
