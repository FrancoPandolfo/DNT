package organizadordeeventos

import grails.plugin.springsecurity.annotation.Secured

//@Secured(['Rol_Usuario'])
class Prueba5Controller {

    @Secured(['ROLE_ADMIN'])
    def index() {
        render "acceso concedido"
    }
}
