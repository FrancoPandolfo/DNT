package organizadordeeventos

class Tarea {

    String nombre
    String descripcion
    Estado estado = Estado.INCOMPLETA

    enum Estado{
        COMPLETA,INCOMPLETA,ENPROCESO
    }

    Tarea(String nombre, String descripcion){
        this.nombre = nombre
        this.descripcion = descripcion
        this.estado = Estado.INCOMPLETA
    }

    def completar(){
        estado = Estado.COMPLETA
    }

    def enProceso(){
        estado = Estado.ENPROCESO
    }

    def reiniciar(){
        estado = Estado.INCOMPLETA
    }
    static constraints = {
      nombre blank:false, nullable: false
    }
}
