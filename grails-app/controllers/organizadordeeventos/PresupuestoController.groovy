package organizadordeeventos
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('permitAll')
class PresupuestoController {
  PresupuestoService presupuestoService

  static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]


  def index(Integer max) {
      params.max = Math.min(max ?: 10, 100)
      respond presupuestoService.list(params), model:[PresupuestoCount: presupuestoService.count()]
  }


  @Secured(['ROLE_COMUN', 'ROLE_ADMIN'])
  def show(Long id) {
    respond presupuestoService.get(id)
  }

  @Secured(['ROLE_ADMIN'])
  def create() {
    respond new Presupuesto(params)
  }

  @Secured(['ROLE_ADMIN'])
  def edit(Long id) {
    respond PresupuestoService.get(id)
  }

  @Secured(['ROLE_COMUN', 'ROLE_ADMIN'])
  def update(Presupuesto presupuesto) {
    if (presupuesto == null) {
        notFound()
        return
    }

    try {
        presupuestoService.save(presupuesto)
    } catch (ValidationException e) {
        respond presupuesto.errors, view:'edit'
        return
    }

    request.withFormat {
        form multipartForm {
            flash.message = message(code: 'default.updated.message', args: [message(code: 'presupuesto.label', default: 'Presupuesto'), presupuesto.id])
            redirect tarea
        }
        '*'{ respond presupuesto, [status: OK] }
    }
  }

  @Secured(['ROLE_ADMIN'])
  def delete(Long id) {
    if (id == null) {
        notFound()
        return
    }

    presupuestoService.delete(id)

    request.withFormat {
        form multipartForm {
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'presupuesto.label', default: 'Presupuesto'), id])
            redirect action:"index", method:"GET"
        }
        '*'{ render status: NO_CONTENT }
    }
  }
}
