package organizadordeeventos

class Prueba3Controller {

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
        def nombre = params.nombre
        def apellido = params.apellido
        def mail = params.mail
        new Usuario(nombre,apellido,mail).save(failOnError: true)

        [nombre:nombre,apellido:apellido,mail:mail]
    }

    def mostrarUsuarios(){

        [
                usuarios: Usuario.list(),
        ]
    }
}
