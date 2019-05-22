package organizadordeeventos

class Tarea {

    String nombre
    String descripcion
    boolean completada

    Tarea(){
        completada = false
    }

    def completarse(){
        completada = true
    }
    static constraints = {
    }
}
