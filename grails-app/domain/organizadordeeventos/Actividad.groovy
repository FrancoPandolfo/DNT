package organizadordeeventos

class Actividad {
    String nombre
    String descripcion
    Date inicio
    Date fin

    Actividad(String nombre, String descripcion, Date inicio, Date fin){
        this.nombre = nombre
        this.descripcion = descripcion
        this.inicio = inicio
        this.fin = fin
    }
    static constraints = {

    }
}
