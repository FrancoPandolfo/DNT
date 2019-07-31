package organizadordeeventos

import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_FULLY'])
class Prueba3Controller {

    class RegistracionCommand {
        String username
        String password

        String nombre
        String apellido
        String mail

        static constraints = {
            nombre blank: false, nullable: false
            apellido blank: false, nullable: false
            mail blank: false, nullable: false, email: true
            password nullable: false, blank: false, password: true
            username nullable: false, blank: false, unique: true
        }
    }

    def index() { }

    def guardarUsuario(){

        def prueba3Service

        def RolDeUsuario = new Role(authority: 'ROLE_COMUN').save(flush: true)
        //def nuevoUsuario = Usuario.findByUsername(params.id)
        def mail = params.mail
        def nombre = params.nombre
        def apellido = params.apellido
        def username = params.usuario
        def password = params.contra
        Usuario nuevoUsuario = new Usuario(nombre:nombre, apellido:apellido,mail: mail,username:username,password: password).save(failOnError: true)
        UsuarioRole.create(nuevoUsuario,RolDeUsuario)
        //if(nuevoUsuario){
            nuevoUsuario.enabled = true
            nuevoUsuario.accountExpired = false
            nuevoUsuario.accountLocked = false
            nuevoUsuario.passwordExpired = false
            nuevoUsuario.authorities ?: RolDeUsuario
            nuevoUsuario.save(failOnError: true)


            /*
            if(prueba3Service.register(nuevoUsuario)){
                flash.message = "Your account has been created. Welcome " + nuevoUsuario.nombre
                flash.message_type = 'success'
                redirect(controller: 'login', action: 'auth')
            }else{
                flash.message = "Unable to create your account. Please try again later"
                flash.message_type = 'danger'
                redirect(action: 'register')
                println("guardando usuario")
            }

             */
        //}else{
            flash.message = "error en creacion"
            /*
            flash.message = "el nombre de usuario ya esta tomado. Porfavor igrese otro"
            flash.message_type = 'peligro'
            println("confirmando usuario")

             */
        //}

        redirect(action: "mostrarUsuarios")

        /*
        def nombreDeUsuario = params.username
        def contraseña = params.password
        def nombre = params.nombre
        def apellido = params.apellido
        def mail = params.mail
        new Usuario(nombre: nombre,apellido: apellido,mail: mail,username: nombreDeUsuario, password: contraseña, enabled: true).save(failOnError: true)

        [nombre:nombre,apellido:apellido,mail:mail, username: nombreDeUsuario, password: contraseña]
        */

    }

    def mostrarUsuarios(){

        [
                usuarios: Usuario.list(),
        ]
    }
}
