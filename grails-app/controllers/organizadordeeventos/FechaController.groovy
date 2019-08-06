package organizadordeeventos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FechaController {

    FechaService fechaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond fechaService.list(params), model:[fechaCount: fechaService.count()]
    }

    def show(Long id) {
        respond fechaService.get(id)
    }

    def create() {
        respond new Fecha(params)
    }

    def save(Fecha fecha) {
        if (fecha == null) {
            notFound()
            return
        }

        try {
            fechaService.save(fecha)
        } catch (ValidationException e) {
            respond fecha.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'fecha.label', default: 'Fecha'), fecha.id])
                redirect fecha
            }
            '*' { respond fecha, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond fechaService.get(id)
    }

    def update(Fecha fecha) {
        if (fecha == null) {
            notFound()
            return
        }

        try {
            fechaService.save(fecha)
        } catch (ValidationException e) {
            respond fecha.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'fecha.label', default: 'Fecha'), fecha.id])
                redirect fecha
            }
            '*'{ respond fecha, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        fechaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'fecha.label', default: 'Fecha'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'fecha.label', default: 'Fecha'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
