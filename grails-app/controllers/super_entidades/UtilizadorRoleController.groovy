package super_entidades

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class UtilizadorRoleController {

    UtilizadorRoleService utilizadorRoleService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond utilizadorRoleService.list(params), model:[utilizadorRoleCount: utilizadorRoleService.count()]
    }

    def show(Long id) {
        respond utilizadorRoleService.get(id)
    }

    def create() {
        respond new UtilizadorRole(params)
    }

    def save(UtilizadorRole utilizadorRole) {
        if (utilizadorRole == null) {
            notFound()
            return
        }

        try {
            utilizadorRoleService.save(utilizadorRole)
        } catch (ValidationException e) {
            respond utilizadorRole.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'utilizadorRole.label', default: 'UtilizadorRole'), utilizadorRole.id])
                redirect utilizadorRole
            }
            '*' { respond utilizadorRole, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond utilizadorRoleService.get(id)
    }

    def update(UtilizadorRole utilizadorRole) {
        if (utilizadorRole == null) {
            notFound()
            return
        }

        try {
            utilizadorRoleService.save(utilizadorRole)
        } catch (ValidationException e) {
            respond utilizadorRole.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'utilizadorRole.label', default: 'UtilizadorRole'), utilizadorRole.id])
                redirect utilizadorRole
            }
            '*'{ respond utilizadorRole, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        utilizadorRoleService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'utilizadorRole.label', default: 'UtilizadorRole'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'utilizadorRole.label', default: 'UtilizadorRole'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
