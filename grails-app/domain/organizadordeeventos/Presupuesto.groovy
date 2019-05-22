package organizadordeeventos

class Presupuesto {

    Integer total
    Integer remanente

    def cargarPresupuesto(Integer presupuesto){
        total = presupuesto
    }

    static constraints = {
    }
}
