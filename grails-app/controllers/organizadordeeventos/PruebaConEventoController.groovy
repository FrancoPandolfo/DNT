package organizadordeeventos

class PruebaConEventoController {

    def index() { }

    def guardarUsuario(){
        def nombre = params.nombre
        def apellido = params.apellido
        def mail = params.mail
        new Usuario(nombre,apellido,mail).save(failOnError: true)

        [nombre:nombre,apellido:apellido,mail:mail]

        redirect(action: "mostrarUsuarios")
    }

    def mostrarUsuarios(){

        [
                usuarios: Usuario.list(),
        ]
    }

    def crearEvento(){

    }

    def guardarEvento(){
        def nombre = params.nombre
        new Evento(nombre).save(failOnError: true)
        [nombre:nombre]
    }

    def menu(){

    }
}