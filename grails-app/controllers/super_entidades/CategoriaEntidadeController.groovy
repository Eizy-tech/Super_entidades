package super_entidades

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CategoriaEntidadeController {

    CategoriaEntidadeService categoriaEntidadeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def descrisao
    def estado
    def DataModif
    def DataRegisto


    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond categoriaEntidadeService.list(params), model: [categoriaEntidadeCount: categoriaEntidadeService.count()]
    }

    def show(Long id) {
        respond categoriaEntidadeService.get(id)
    }

    def create() {
        respond new CategoriaEntidade(params)

    }

    def save(CategoriaEntidade categoriaEntidade) {
        if (categoriaEntidade == null) {
            notFound()
            return
        }

        try {
            categoriaEntidadeService.save(categoriaEntidade)
        } catch (ValidationException e) {
            respond categoriaEntidade.errors, view: 'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'categoriaEntidade.label', default: 'CategoriaEntidade'), categoriaEntidade.id])
                redirect categoriaEntidade
            }
            '*' { respond categoriaEntidade, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond categoriaEntidadeService.get(id)
    }

    def update(CategoriaEntidade categoriaEntidade) {
        if (categoriaEntidade == null) {
            notFound()
            return
        }

        try {
            categoriaEntidadeService.save(categoriaEntidade)
        } catch (ValidationException e) {
            respond categoriaEntidade.errors, view: 'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'categoriaEntidade.label', default: 'CategoriaEntidade'), categoriaEntidade.id])
                redirect categoriaEntidade
            }
            '*' { respond categoriaEntidade, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        categoriaEntidadeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'categoriaEntidade.label', default: 'CategoriaEntidade'), id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'categoriaEntidade.label', default: 'CategoriaEntidade'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }

    def salvar() {
//        def entidade
//        def idEntidade = params.idEntidade.toInteger()
//        if (idEntidade == null) {
//            Entidade = EntidadeController.salvarEntidade(new Entidade())
//            Entidade.codigo = EntidadeController.codigoEntidade()
//        } else {
//            entidade = EntidadeController.salvarEntidade(Entidade.get(idEntidade))
//        }
        def categoriaEntidade
        if (params.categoriaEntidade) {
            categoriaEntidade = categoriaEntidade.get(params.categoriaEntidade)
        }
        categoriaEntidade.estado = "Activo"
        CategoriaEntidade.dataModif = new Date()
        CategoriaEntidade.dataRegisto = new Date()

    }

}