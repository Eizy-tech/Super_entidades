package super_entidades

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ContactoMsgController {

    ContactoMsgService contactoMsgService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        //Qualquer coisa
        params.max = Math.min(max ?: 10, 100)
        respond contactoMsgService.list(params), model:[contactoMsgCount: contactoMsgService.count()]
    }

    def show(Long id) {
        respond contactoMsgService.get(id)
    }

    def create() {
        respond new ContactoMsg(params)
    }

    def save(ContactoMsg contactoMsg) {
        if (contactoMsg == null) {
            notFound()
            return
        }

        try {
            contactoMsgService.save(contactoMsg)
        } catch (ValidationException e) {
            respond contactoMsg.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'contactoMsg.label', default: 'ContactoMsg'), contactoMsg.id])
                redirect contactoMsg
            }
            '*' { respond contactoMsg, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond contactoMsgService.get(id)
    }

    def update(ContactoMsg contactoMsg) {
        if (contactoMsg == null) {
            notFound()
            return
        }

        try {
            contactoMsgService.save(contactoMsg)
        } catch (ValidationException e) {
            respond contactoMsg.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'contactoMsg.label', default: 'ContactoMsg'), contactoMsg.id])
                redirect contactoMsg
            }
            '*'{ respond contactoMsg, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        contactoMsgService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'contactoMsg.label', default: 'ContactoMsg'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'contactoMsg.label', default: 'ContactoMsg'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
