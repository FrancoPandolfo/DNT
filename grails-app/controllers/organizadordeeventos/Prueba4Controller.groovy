package organizadordeeventos

import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_FULLY'])
class Prueba4Controller {

    class RegistracionCommand {

        String nombre
        String apellido
        String mail

        static constraints = {
            nombre blank: false, nullable: false
            apellido blank: false, nullable: false
            mail blank: false, nullable: false, email: true
        }
    }

    def index() { }

    def guardarUsuario(){
        def RolDeUsuario = new Role(authority: 'ROLE_COMUN').save(flush: true)
        def nombre = params.nombre
        def apellido = params.apellido
        def mail = params.mail
        def username = params.username
        def password = params.password
        Usuario nuevoUsuario = new Usuario(nombre:nombre,apellido:apellido,mail:mail,username: username,password: password,enabled: true).save(failOnError: true)
        UsuarioRole.create(nuevoUsuario,RolDeUsuario)
        [nombre:nombre,apellido:apellido,mail:mail]

        redirect(action: "mostrarUsuarios")
    }

    def mostrarUsuarios(){

        [
                usuarios: Usuario.list(),
        ]
    }
}

