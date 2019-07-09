package organizadordeeventos


class Administrador extends Usuario {
    Evento evento

    Administrador(Usuario usuario,Evento evento){
        this.nombre = usuario.nombre
        this.apellido = usuario.apellido
        this.mail = usuario.mail
        this.evento = evento
    }

    //¿hace falta que estas funciones esten en evento?
    //¿podriamos tener una lista de todas las instancias de usuario y asi buscar por String nombre?
    def agregarUsuario(Usuario usuario){
        usuario.eventos.add(evento)
    }

    def agregarAdministrador(Usuario usuario){
        Administrador admin = new Administrador(usuario,evento)
        usuario.eventos.add(evento)
    }

    def cargarPresupuesto(BigDecimal presu){
        Presupuesto presupuesto = new Presupuesto(presu)
        evento.presupuesto = presupuesto
    }

    //¿hay que encapsular total y remanente? ¿como hacemos?
    def agregarPresupuesto(BigDecimal masPresupuesto){
        Dinero presupuesto = new Dinero(masPresupuesto)
        (evento.presupuesto.total) += presupuesto

        Dinero remanente = evento.presupuesto.getRemanente()
        remanente = remanente + presupuesto
        evento.presupuesto.setRemanente(remanente)
    }

    def quitarPresupuesto(BigDecimal menosPresupuesto){
        Dinero presupuesto = new Dinero(menosPresupuesto)
        if(evento.presupuesto.total.compareTo(presupuesto) < 0){
            throw new IllegalArgumentException("Monto ingresado superior al presupuesto actual")
        }
        (evento.presupuesto.total) -= presupuesto

        Dinero remanente = evento.presupuesto.getRemanente()
        remanente = remanente - presupuesto
        evento.presupuesto.setRemanente(remanente)
    }

    def fijarLocacion(String location){
        evento.locacion = location
    }

    def borrarLocacion(){
        evento.locacion = ""
    }

    def fijarFecha(Date date){
        evento.fecha = date
    }

    //¿esta bien esto?
    def borrarFecha(){
        evento.fecha = null
    }

    static constraints = {
      evento nullable: false
    }
}
