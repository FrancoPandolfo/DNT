package organizadordeeventos

class Dinero {

    Integer cantidad

   def getCantidad(){
        return cantidad
    }

    def setCantidad(Integer cant){
        cantidad = cant
    }

    def sumar(Integer cant){
        cantidad += cant
    }

    def restar(Integer cant){
        cantidad -= cant
    }
    static constraints = {
    }
}
