package organizadordeeventos

import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
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
      def nuevoUsuario = Usuario.findByUsername(params.id)
      if(!nuevoUsuario){
        nuevoUsuario.username = params.usuario
        nuevoUsuario.mail = params.mail
        nuevoUsuario.nombre = params.nombre
        nuevoUsuario.apellido = params.apellido
        nuevoUsuario.password = params.contra

        nuevoUsuario.accountExpired = false
        nuevoUsuario.accountLocked = false
        nuevoUsuario.passwordExpired = false
        nuevoUsuario.authorities ?: RolDeUsuario
        if(prueba3Service.register(nuevoUsuario)){
            flash.message = "Your account has been created. Welcome " + nuevoUsuario.nombre
            flash.message_type = 'success'
            redirect(controller: 'login', action: 'auth')
        }
        else{
            flash.message = "Unable to create your account. Please try again later"
            flash.message_type = 'danger'
            redirect(action: 'register')
            println("guardando usuario")
        }
      }
      else{
          flash.message = "el nombre de usuario ya esta tomado. Porfavor igrese otro"
          flash.message_type = 'peligro'
          println("confirmando usuario")
        }
    }

    def mostrarUsuarios(){

        [
                usuarios: Usuario.list(),
        ]
    }
}
