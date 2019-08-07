package organizadordeeventos

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
class PruebaUnoCommand {
    String nombre

    static constraints = {
        nombre nullable: false
    }
}

//@Secured(['IS_AUTHENTICATED_FULLY'])
@Secured(['ROLE_COMUN','ROLE_ADMIN'])
class PruebaUnoController {

    def springSecurityService
    def pruebaUnoService

    def index() {

        //Object usuarioPrincipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal()
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication()
        //String username = ((UserDetails)usuarioPrincipal).getUsername()
        //Long userId = sprinSecurityService.currentUser
        //Usuario usuarioActual = pruebaUnoService.getUsuarioActual(userId)

        Usuario usuarioActual = springSecurityService.currentUser
        render "${usuarioActual.nombre} "
        render "${usuarioActual.apellido}"


        [
                eventos: usuarioActual.eventos
        ]



    }

    def crearEvento(){
    }

    def guardarEvento(PruebaUnoCommand cmd){
        Usuario usuarioActual = springSecurityService.currentUser
        pruebaUnoService.crearEvento(usuarioActual,cmd.nombre)
        redirect (action: "index")
    }

    def eliminarEvento(){
        Usuario usuarioActual = springSecurityService.currentUser
        pruebaUnoService.eliminarEvento(usuarioActual,evento)
    }

    def cargarProveedor(){
        String nombre = params.nombre
        Usuario usuarioActual = springSecurityService.currentUser
        pruebaUnoService.cargarProveedor(usuarioActual,nombre)
        redirect (action: "index")
    }
}
