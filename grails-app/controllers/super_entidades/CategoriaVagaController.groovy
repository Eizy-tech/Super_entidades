package super_entidades

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CategoriaVagaController {

    CategoriaVagaService categoriaVagaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond categoriaVagaService.list(params), model:[categoriaVagaCount: categoriaVagaService.count()]
    }

    def show(Long id) {
        respond categoriaVagaService.get(id)
    }

    def create() {
        respond new CategoriaVaga(params)
    }

    def save(CategoriaVaga categoriaVaga) {
        if (categoriaVaga == null) {
            notFound()
            return
        }

        try {
            categoriaVagaService.save(categoriaVaga)
        } catch (ValidationException e) {
            respond categoriaVaga.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'categoriaVaga.label', default: 'CategoriaVaga'), categoriaVaga.id])
                redirect categoriaVaga
            }
            '*' { respond categoriaVaga, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond categoriaVagaService.get(id)
    }

    def update(CategoriaVaga categoriaVaga) {
        if (categoriaVaga == null) {
            notFound()
            return
        }

        try {
            categoriaVagaService.save(categoriaVaga)
        } catch (ValidationException e) {
            respond categoriaVaga.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'categoriaVaga.label', default: 'CategoriaVaga'), categoriaVaga.id])
                redirect categoriaVaga
            }
            '*'{ respond categoriaVaga, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        categoriaVagaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'categoriaVaga.label', default: 'CategoriaVaga'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'categoriaVaga.label', default: 'CategoriaVaga'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
