package organizadordeeventos

class Presupuesto {

    Dinero total
    Dinero remanente

    def cargarPresupuesto(Integer presupuesto) {
        total.setCantidad(presupuesto)
        remanente.setCantidad(presupuesto)
    }

    def getRemanente(){
        return remanente
    }

    static constraints = {
    }
}