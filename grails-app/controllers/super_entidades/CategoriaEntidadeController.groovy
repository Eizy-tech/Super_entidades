package super_entidades

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

import java.time.DateTimeException

import static org.springframework.http.HttpStatus.*

class CategoriaEntidadeController {

    CategoriaEntidadeService categoriaEntidadeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    // metodo de verificao nao nullo e vazio
    def notNullEmpty( String var){
        def result = true

        if (var == null || var == ""){
            result == false
        }
    }
    // Metodo para adicionar categoriaEntidade
    // Somente utilizador autorizado
    @Secured(['ROLE_ADMIN' , 'ROLE_USER'])
    def salvar() {

        // declaracao
        def descrisao
        def estado
        def dataModif
        def dataRegisto
        def categoriaEntidade = new CategoriaEntidade()

        // validacao & atribuicao
        if (notNullEmpty(params.descricao)) {
            descrisao = params.descrisao
            categoriaEntidade.descrisao = descrisao
        }
        if (notNullEmpty(params.estado)){
            estado = params.estado
            categoriaEntidade.estado = estado
        }
        if (notNullEmpty(params.dataMofif)){
            categoriaEntidade.dataModif = Date.parse("yyyy-MM-dd",dataModif)
        }
        if(notNullEmpty(params.dataRegisto)){
            categoriaEntidade.dataRegisto = Date.parse("yyyy-MM-dd",dataRegisto)
        }

        def msg = [:]
        try {
            categoriaEntidade.save(flush: true)
            msg['msg'] = "Salvo com Sucesso"
        } catch (Exception e) {
           msg['msg'] = e.getMessage()
        }
        return categoriaEntidade
    }


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


}