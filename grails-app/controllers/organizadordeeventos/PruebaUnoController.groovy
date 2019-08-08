package organizadordeeventos

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
class NombreEventoCommand {
    String nombre

    static constraints = {
        nombre nullable: false
    }
}

class IdEventoCommand {
    Long evento

    static constraints = {
        evento nullable: false
    }
}

class NombreProveedorCommand{
    String nombre
    static constraints = {
        nombre nullable: false
    }
}

class IdProveedorCommand{
    Long proveedor
    static constraints = {
        proveedor nullable: false
    }
}

//@Secured(['IS_AUTHENTICATED_FULLY'])
@Secured(['ROLE_COMUN','ROLE_ADMIN'])
class PruebaUnoController {

    def springSecurityService
    def pruebaUnoService

    def index() {

        Usuario usuarioActual = springSecurityService.currentUser
        render "${usuarioActual.nombre} "
        render "${usuarioActual.apellido}"


        [
                eventos: Evento.list(),
                proveedores: usuarioActual.proveedores
        ]



    }

    def crearEvento(){
    }

    def guardarEvento(NombreEventoCommand cmd){
        Usuario usuarioActual = springSecurityService.currentUser
        pruebaUnoService.crearEvento(usuarioActual,cmd.nombre)
        redirect (action: "index")
    }

    def eliminarEvento(IdEventoCommand cmd){
        Usuario usuarioActual = springSecurityService.currentUser
        //evento es null ! no lo esta encontrando
        Evento evento = Evento.get(cmd.evento)
        pruebaUnoService.eliminarEvento(usuarioActual, evento)
        redirect(action: "index")
    }

    def cargarProveedor(){
    }

    def crearProveedor(NombreProveedorCommand cmd){
        Usuario usuarioActual = springSecurityService.currentUser
        pruebaUnoService.cargarProveedor(usuarioActual,cmd.nombre)
        redirect (action: "index")
    }

    def quitarProveedor(IdProveedorCommand cmd){
        Usuario usuarioActual = springSecurityService.currentUser
        Proveedor proveedor = Proveedor.get(cmd.proveedor)
        pruebaUnoService.quitarProveedor(usuarioActual,proveedor)
        redirect (action: "index")
    }
}
