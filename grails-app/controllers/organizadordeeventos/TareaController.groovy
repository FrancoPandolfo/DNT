package organizadordeeventos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured


@Secured(['permitAll'])
class TareaController {

    TareaService tareaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]


    @Secured(['ROLE_COMUN'])
    def tareaCompletada(Long id) {
      Tarea tarea = Tarea.get(id)
      tareaService.completar()
      redirect(controller:"evento",action:"misTareas")
    }

    @Secured(['ROLE_COMUN'])
    def tareaEnProceso(Long id) {
      Tarea tarea = Tarea.get(id)
      tareaService.enProceso()
      redirect(controller:"evento",action:"misTareas")
    }

    @Secured(['ROLE_COMUN'])
    def tareareiniciada(Long id) {
        Tarea tarea = Tarea.get(id)
        tareaService.reiniciar()
        redirect(controller:"evento",action:"misTareas")
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond eventoService.list(params), model:[TareaCount: tareaService.count()]
    }


    @Secured(['ROLE_COMUN', 'ROLE_ADMIN'])
    def show(Long id) {
      respond tareaService.get(id)
    }

    @Secured(['ROLE_COMUN', 'ROLE_ADMIN'])
    def create() {
      respond new Tarea(params)
    }

    @Secured(['ROLE_COMUN', 'ROLE_ADMIN'])
    def edit(Long id) {
      respond tareaService.get(id)
    }

    @Secured(['ROLE_COMUN', 'ROLE_ADMIN'])
    def update(Tarea tarea) {
      if (tarea == null) {
          notFound()
          return
      }

      try {
          tareaService.save(tarea)
      } catch (ValidationException e) {
          respond tarea.errors, view:'edit'
          return
      }

      request.withFormat {
          form multipartForm {
              flash.message = message(code: 'default.updated.message', args: [message(code: 'tarea.label', default: 'Tarea'), tarea.id])
              redirect tarea
          }
          '*'{ respond tarea, [status: OK] }
      }
    }

    @Secured(['ROLE_COMUN', 'ROLE_ADMIN'])
    def delete(Long id) {
      if (id == null) {
          notFound()
          return
      }

      tareaService.delete(id)

      request.withFormat {
          form multipartForm {
              flash.message = message(code: 'default.deleted.message', args: [message(code: 'tarea.label', default: 'Tarea'), id])
              redirect action:"index", method:"GET"
          }
          '*'{ render status: NO_CONTENT }
      }
    }
}
