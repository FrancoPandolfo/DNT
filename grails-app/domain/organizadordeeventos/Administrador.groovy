package organizadordeeventos

class Administrador extends Usuario {
    Evento evento

    Administrador(Usuario usuario,Evento event){
        this.nombre = usuario.nombre
        this.apellido = usuario.apellido
        this.mail = usuario.mail
        evento = event
    }

    //¿hace falta que estas funciones esten en evento?
    //¿podriamos tener una lista de todas las instancias de usuario y asi buscar por String nombre?
    agregarUsuario(Usuario usuario){
        evento.usuarios.add(usuario)
        usuario.eventos.add(evento)
    }

    agregarAdministrador(Usuario usuario){
        Administrador admin = new Administrador(usuario,evento)
        evento.administradores.add(admin)
        usuario.eventos.add(evento)
    }

    def cargarPresupuesto(BigDecimal presu){
        Presupuesto presupuesto = new Presupuesto(presu)
        evento.presupuesto = presupuesto
    }

    static constraints = {
      evento nullable: false
    }
}
