package organizadordeeventos

class Cronograma {

    Set<Actividad> actividades =[]
    Buscador buscador


    def agregarActividad(Actividad actividad){
        actividades.add(actividad)
    }

    def quitarActividad(Actividad actividad){
        //Actividad actividad = buscador.buscarActividad(nombre,actividades)
        //if(actividad == null){throw new IllegalArgumentException("no se encontro proveedor con ese nombre")}
        actividades.removeElement(actividad)
    }


    static hasMany=[
            actividades: Actividad
    ]

    static constraints = {
    }
}
