package super_entidades

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PortifolioItemController {

    PortifolioItemService portifolioItemService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond portifolioItemService.list(params), model:[portifolioItemCount: portifolioItemService.count()]
    }

    def show(Long id) {
        respond portifolioItemService.get(id)
    }

    def create() {
        respond new PortifolioItem(params)
    }

    def save(PortifolioItem portifolioItem) {
        if (portifolioItem == null) {
            notFound()
            return
        }

        try {
            portifolioItemService.save(portifolioItem)
        } catch (ValidationException e) {
            respond portifolioItem.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'portifolioItem.label', default: 'PortifolioItem'), portifolioItem.id])
                redirect portifolioItem
            }
            '*' { respond portifolioItem, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond portifolioItemService.get(id)
    }

    def update(PortifolioItem portifolioItem) {
        if (portifolioItem == null) {
            notFound()
            return
        }

        try {
            portifolioItemService.save(portifolioItem)
        } catch (ValidationException e) {
            respond portifolioItem.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'portifolioItem.label', default: 'PortifolioItem'), portifolioItem.id])
                redirect portifolioItem
            }
            '*'{ respond portifolioItem, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        portifolioItemService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'portifolioItem.label', default: 'PortifolioItem'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'portifolioItem.label', default: 'PortifolioItem'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
