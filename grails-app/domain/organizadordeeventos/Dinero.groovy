package organizadordeeventos

class Dinero {

    Integer cantidad

    getCantidad(){
        return cantidad
    }

    setCantidad(Integer cant){
        cantidad = cant
    }

    sumar(Integer cant){
        cantidad += cant
    }

    restar(Integer cant){
        cantidad -= cant
    }
    static constraints = {
    }
}
