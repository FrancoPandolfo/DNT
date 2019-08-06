package organizadordeeventos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import java.time.LocalDateTime

@Secured(['permitAll'])
class PosiblesFechasController {

    PosiblesFechasService posiblesFechasService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond posiblesFechasService.list(params), model:[posiblesFechasCount: posiblesFechasService.count()]
    }

    def show(Long id) {
        respond posiblesFechasService.get(id)
    }

    def create() {
        respond new PosiblesFechas(params)
    }

    def save(PosiblesFechas posiblesFechas) {
        if (posiblesFechas == null) {
            notFound()
            return
        }

        try {
            posiblesFechasService.save(posiblesFechas)
        } catch (ValidationException e) {
            respond posiblesFechas.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'posiblesFechas.label', default: 'PosiblesFechas'), posiblesFechas.id])
                redirect posiblesFechas
            }
            '*' { respond posiblesFechas, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond posiblesFechasService.get(id)
    }

    def update(PosiblesFechas posiblesFechas) {
        if (posiblesFechas == null) {
            notFound()
            return
        }

        try {
            posiblesFechasService.save(posiblesFechas)
        } catch (ValidationException e) {
            respond posiblesFechas.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'posiblesFechas.label', default: 'PosiblesFechas'), posiblesFechas.id])
                redirect posiblesFechas
            }
            '*'{ respond posiblesFechas, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        posiblesFechasService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'posiblesFechas.label', default: 'PosiblesFechas'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'posiblesFechas.label', default: 'PosiblesFechas'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    @Secured
    def agregarFecha(){
     List<LocalDateTime> fechas = params.findAll{ param ->
         param.key.toString().startsWith("horario-")
     }.collect { param ->
         LocalDateTime.parse(param.value.toString())
     }
     canchaService.generarTurnos(Long.valueOf(params.id.toString()), fechas)
     redirect(action: "misFechas", params: [posiblesFechasId: params.id])
    }
}
