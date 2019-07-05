package organizadordeeventos


class Presupuesto {

    Dinero total
    Dinero remanente

    Presupuesto(BigDecimal presupuesto){
        Dinero total = new Dinero(presupuesto)
        this.total = total
        this.remanente = total
    }

    def getRemanente(){
        return remanente
    }

    def setRemanente(Dinero remanenteNuevo){
      this.remanente = remanenteNuevo
    }

    static constraints = {
      total blank: false, nullable: false
    }
}
