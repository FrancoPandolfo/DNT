package organizadordeeventos

class Buscador {


    def buscarProveedor(String name,Set<Proveedor> proveedores)throws NullPointerException{
        for(prov in proveedores ){
            if (prov.nombre == name) {
                return prov
            }
        }
        return null
    }

    def buscarActividad(String name, Set<Actividad>actividades)throws NullPointerException{
        for(act in actividades ){
            if (act.nombre == name) {
                return act
            }
        }
        return null
    }

    def buscarInfraestructura(String name,Set<Item>infraestructura)throws NullPointerException{
        for(infra in infraestructura ){
            if (infra.nombre == name) {
                return infra
            }
        }
        return null
    }

    def buscarTarea(String name,Set<Tarea>tareas)throws NullPointerException{
        for(tarea in tareas ){
            if (tarea.nombre == name) {
                return tarea
            }
        }
        return null
    }

    def buscarEvento(String name, Set<Evento>eventos)throws NullPointerException{
            for(even in eventos ){
                if (even.nombre == name) {
                    return even
                }
            }
            return null
    }

    static constraints = {
    }
}
