package organizadordeeventos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured


@Secured(['permitAll'])
class NotaController {

    NotaService notaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() { }


    @Secured(['ROLE_COMUN', 'ROLE_ADMIN'])
    def show(Long id) {
      respond notaService.get(id)
    }

    @Secured(['ROLE_COMUN', 'ROLE_ADMIN'])
    def create() {
      respond new Nota(params)
    }

    @Secured(['ROLE_COMUN', 'ROLE_ADMIN'])
    def edit(Long id) {
      respond notaService.get(id)
    }

    @Secured(['ROLE_COMUN', 'ROLE_ADMIN'])
    def update(Nota nota) {
      if (nota == null) {
          notFound()
          return
      }

      try {
          notaService.save(nota)
      } catch (ValidationException e) {
          respond nota.errors, view:'edit'
          return
      }

      request.withFormat {
          form multipartForm {
              flash.message = message(code: 'default.updated.message', args: [message(code: 'nota.label', default: 'Nota'), nota.id])
              redirect nota
          }
          '*'{ respond nota, [status: OK] }
      }
    }

    @Secured(['ROLE_COMUN', 'ROLE_ADMIN'])
    def delete(Long id) {
      if (id == null) {
          notFound()
          return
      }

      notaService.delete(id)

      request.withFormat {
          form multipartForm {
              flash.message = message(code: 'default.deleted.message', args: [message(code: 'nota.label', default: 'Nota'), id])
              redirect action:"index", method:"GET"
          }
          '*'{ render status: NO_CONTENT }
      }
    }
}
