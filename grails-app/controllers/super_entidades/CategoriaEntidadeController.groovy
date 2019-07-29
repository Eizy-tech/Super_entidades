package super_entidades

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

import java.time.DateTimeException

import static org.springframework.http.HttpStatus.*
@Secured(['ROLE_ADMIN' , 'ROLE_USER'])

class CategoriaEntidadeController {

    CategoriaEntidadeService categoriaEntidadeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def springSecurityService
    def utilizadorLogado(){
        def utilizador = (Utilizador)springSecurityService.currentUser
        return utilizador
    }

    // Metodo para adicionar categoriaEntidade
    // Somente utilizador autorizado

    @Secured(['ROLE_ADMIN' , 'ROLE_USER'])
    def salvar(CategoriaEntidade categoriaEntidade) {

        categoriaEntidade.setDataRegisto(new Date())
        categoriaEntidade.setDataModif(new Date())

        categoriaEntidade.utilizadorRegisto = utilizadorLogado()
        categoriaEntidade.utilizadorModif = utilizadorLogado()

        def msg = [:]
        try {
            categoriaEntidadeService.save(categoriaEntidade)
            msg['msg'] = "Salvo com Sucesso"
            msg['categoriaEntidade'] = categoriaEntidade
        } catch (ValidationException e) {
            msg ['msg'] = "Error:" + e.getMessage()
        }
        render msg as JSON
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond categoriaEntidadeService.list(params), model: [categoriaEntidadeCount: categoriaEntidadeService.count()]
    }

    def show(Long id) {
        respond categoriaEntidadeService.get(id)
    }
    def show2(Long id) {
        render Entidade.get(id) as JSON
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


}