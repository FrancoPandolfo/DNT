package organizadordeeventos

import grails.plugin.springsecurity.annotation.Secured

class PruebaUnoEventoCommand {
    Long evento

    static constraints = {
        evento nullable: false
    }
}

//@Secured(['permitAll'])
@Secured(['ROLE_COMUN','ROLE_ADMIN'])
class PruebaUnoEventoController {

    def springSecurityService
    def pruebaUnoEventoService

    def index(PruebaUnoEventoCommand cmd) {
        if (!cmd.hasErrors()) {
         Evento evento = Evento.findById(cmd.evento)
         render "${evento.nombre} "
         Usuario usuarioActual = springSecurityService.currentUser

        [
                proveedores      : usuarioActual.proveedores,
                actividades      : evento.cronograma.actividades,
                tareas           : evento.tareas,
                notas            : evento.notas,
                proveedoresEvento: evento.proveedores
        ]
     }
        else {
            render "hay errores ${cmd.errors}"
        }
    }

    def cambiarNombre(){

    }
}
