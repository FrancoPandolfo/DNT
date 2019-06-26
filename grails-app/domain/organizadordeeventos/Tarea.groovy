package organizadordeeventos

class Tarea {

    String nombre
    String descripcion
    Estado estado = Estado.INCOMPLETA

    enum Estado{
        COMPLETA,INCOMPLETA,ENPROCESO
    }

    Tarea(String name, String descrip){
        nombre = name
        descripcion = descrip
        estado = Estado.INCOMPLETA
    }

    def completa(){
        estado = Estado.COMPLETA
    }

    def enProceso(){
        estado = Estado.ENPROCESO
    }

    def incompleta(){
        estado = Estado.INCOMPLETA
    }
    static constraints = {
      nombre blank:false, nullable: false
    }
}
