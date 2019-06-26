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

    //¿hay que encapsular total y remanente? ¿como hacemos?
    def agregarPresupuesto(BigDecimal presu){
        Dinero presupuesto = new Dinero(presu)
        evento.presupuesto.total.plus(presupuesto)

        Dinero remanente = evento.presupuesto.getRemanente()
        remanente.plus(presupuesto)
        evento.presupuesto.setRemanente(remanente)
    }

    def quitarPresupuesto(BigDecimal presu){
        Dinero presupuesto = new Dinero(presu)
        if(evento.presupuesto.total.compareTo(presupuesto) < 0){
            throw new IllegalArgumentException("Monto ingresado superior al presupuesto actual")
        }
        evento.presupuesto.total.minus(presupuesto)

        Dinero remanente = evento.presupuesto.getRemanente()
        remanente.minus(presupuesto)
        evento.presupuesto.setRemanente(remanente)
    }

    def fijarLocacion(String location){
        evento.locacion = location
    }

    def borrarLocacion(){
        evento.locacion = ""
    }

    static constraints = {
      evento nullable: false
    }
}
