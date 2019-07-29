package organizadordeeventos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class EventoController {


    EventoService eventoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]


    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond eventoService.list(params), model:[eventoCount: eventoService.count()]
    }

    @Secured(['ROLE_COMUN'])
    def show(Long id) {
        respond eventoService.get(id)
    }

    def create() {
        respond new Evento(params)
    }


    def edit(Long id) {
        respond eventoService.get(id)
    }

    def update(Evento evento) {
        if (evento == null) {
            notFound()
            return
        }

        try {
            eventoService.save(evento)
        } catch (ValidationException e) {
            respond evento.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'evento.label', default: 'Evento'), evento.id])
                redirect evento
            }
            '*'{ respond evento, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        eventoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'evento.label', default: 'Evento'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'evento.label', default: 'Evento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    @Secured(['ROLE_COMUN'])
    def misTareas(){
      Usuario usuario = authenticatedUser
      respond (evento.tareas, model:[id:Evento.id])
    }
}
