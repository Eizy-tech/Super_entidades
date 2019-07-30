package super_entidades

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class VagaController {

    VagaService vagaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

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
