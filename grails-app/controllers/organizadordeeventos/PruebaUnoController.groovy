package organizadordeeventos

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails

@Secured(['IS_AUTHENTICATED_FULLY'])
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

        def nombre = params.nombre

        Evento evento = new Evento(nombre).save()
        Usuario usuarioActual = springSecurityService.currentUser

        pruebaUnoService.agregarEvento(usuarioActual,evento)

    }
}
