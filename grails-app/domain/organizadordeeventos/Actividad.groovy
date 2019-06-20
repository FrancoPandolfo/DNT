package organizadordeeventos

class Actividad {
    String nombre
    String descripcion
    Date inicio
    Date fin

    Actividad(String name, String descrip, Date ini, Date end){
        nombre = name
        descripcion = descrip
        inicio = ini
        fin = end
    }
    static constraints = {

    }
}
