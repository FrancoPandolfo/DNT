package organizadordeeventos

class Administrador extends Usuario {
    Evento evento

    Administrador(Usuario usuario,Evento event){
        this.nombre = usuario.nombre
        this.apellido = usuario.apellido
        this.mail = usuario.mail
        evento = event

    }
    static constraints = {
      evento nullable: false
    }
}
