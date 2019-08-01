package organizadordeeventos

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.http.HttpStatus

/*
class ConEventoCommand {
    Long evento

    static constraints = {
        evento nullable: false
    }
}
*/

@Secured(['IS_AUTHENTICATED_FULLY'])
class PruebaConEventoController {

    def PruebaConEventoService

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

    @SuppressWarnings(['FactoryMethodName', 'GrailsMassAssignment'])
    def crearEvento(){
        def nombre = params.nombre
        respond new Evento(nombre)
        [nombre:nombre]
    }

    def guardarEvento(Evento evento){
        /*
        if (evento == null) {
            render status: HttpStatus.NOT_FOUND
            return
        }

        if (evento.hasErrors()) {
            respond evento.errors, view: 'crearEvento'
            return
        }
        */

        evento.save(failOnError: true)

        /*
        request.withFormat {
            form multipartForm { redirect evento }
            '*' { respond evento, status: HttpStatus.CREATED }
        }

         */

        // como guardar datos en el evento
        //cada operacion deberia tener un boton de enviar formulario

        //operaciones de admin
        def presupuesto = params.presupuesto
        def agregarPresupuesto = params.agregarPresupuesto
        def quitarPresupuesto = params.quitarPresupuesto
        def locacion = params.locacion
        def fecha = params.fecha

        //operaciones de evento
        def proveedor = params.proveedor
        def quitarProveedor = params.quitarProveedor
        def compra = params.compra
        def quitarCompra = params.quitarCompra
        def actividad = params.actividad
        def quitarActividad = params.quitarActividad
        def tarea = params.tarea
        def quitarTarea = params.quitarTarea
        //menu de tarea
        def nota = params.nota
        def quitarNota = params.quitarNota

        //propuestas
        def propuestaPresupuesto = params.propuestaPresupuesto
        def quitarPropuestaPresupuesto = params.quitarPropuestaPresupuesto
        def propuestaFecha = params.propuestaFecha
        def quitarPropuestaFecha = params.quitarPropuestaFecha

        evento.presupuesto = presupuesto


    }

    def mostrarEvento(){
        [
               eventos: Evento.list(),
        ]
    }

    def mostrarPresupuesto(Evento evento){

        println(evento.presupuesto)
    }
}