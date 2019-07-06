package organizadordeeventos

class CrearEventoCommand {
    Long usuario
    //Long evento

    static constraints = {
        usuario nullable: false
       //evento nullable: false
    }
}

class Prueba2Controller {

    def prueba2Service

    def index() {
      [
        usuarios: Usuario.list(),
      ]
    }

    def index2(){
        [
        eventos: Evento.list()
        ]
    }

    def datosDePrueba() {

      new Usuario('nombreDeUsuario 1',  'apellido', 'email@email.com').save(failOnError: true)
      new Usuario('nombreDeUsuario 2',  'apellido', 'email@email.com').save(failOnError: true)
      new Usuario('nombreDeUsuario 3', 'apellido', 'email@email.com').save(failOnError: true)
      new Usuario('nombreDeUsuario 4', 'apellido', 'email@email.com').save(failOnError: true)

      render "todo ok"
    }

    def CrearUnEvento(CrearEventoCommand cmd) {
      if (!cmd.hasErrors()) {
        assert prueba2Service != null
          Evento evento = prueba2Service.crearUnEvento(cmd.usuario)
        render "OK ${evento.nombre}"
      } else {
        render "hay errores ${cmd.errors}"
      }
    }
}
