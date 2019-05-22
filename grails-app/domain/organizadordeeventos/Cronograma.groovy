package organizadordeeventos

class Cronograma {

    Set<Actividad> actividades =[]
    Buscador buscador


    def agregarActividad(){
        Actividad actividad = new Actividad()
        actividades.add(actividad)
    }

    def quitarActividad(String nombre){
        Actividad actividad = buscador.buscarActividad(nombre,actividades)
        if(actividad == null){throw new IllegalArgumentException("no se encontro proveedor con ese nombre")}
        actividades.removeElement(actividad)
    }


    static hasMany=[
            actividades: Actividad
    ]

    static constraints = {
    }
}
