package super_entidades

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*


@Secured(['ROLE_ADMIN' , 'ROLE_USER'])
class VisitaController {

    VisitaService visitaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    // Metodo para adicionar visita
    // Somente utilizador autorizado

    @Secured(['ROLE_ADMIN' , 'ROLE_USER'])
    def salvar(Visita visita) {

        visita.setDataRegisto(new Date())
        visita.setDataModif(new Date())

        def msg = [:]
        try {
            visitaService.save(visita)
            msg['msg'] = "Done"
            msg['visita'] = visita
        } catch (ValidationException e) {
            msg ['msg'] = "Error:" + e.getMessage()
        }
        render msg as JSON
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond visitaService.list(params), model:[visitaCount: visitaService.count()]
    }

    def show(Long id) {
        respond visitaService.get(id)
    }

    def create() {
        respond new Visita(params)
    }

    def save(Visita visita) {
        if (visita == null) {
            notFound()
            return
        }

        try {
            visitaService.save(visita)
        } catch (ValidationException e) {
            respond visita.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'visita.label', default: 'Visita'), visita.id])
                redirect visita
            }
            '*' { respond visita, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond visitaService.get(id)
    }

    def update(Visita visita) {
        if (visita == null) {
            notFound()
            return
        }

        try {
            visitaService.save(visita)
        } catch (ValidationException e) {
            respond visita.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'visita.label', default: 'Visita'), visita.id])
                redirect visita
            }
            '*'{ respond visita, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        visitaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'visita.label', default: 'Visita'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'visita.label', default: 'Visita'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
