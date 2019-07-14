package organizadordeeventos

class PosiblesFechas {
    private Set<Fecha> fechas = []

    public void agregarPosibleFecha(Date fecha){
      Fecha fechaaAgregar = new Fecha(fecha)
      def fechaAnterior = this.fechas.find { i -> i == fechaaAgregar }
      if (fechaAnterior){
        fechaAnterior.votar()
      }
      else{
        fechas.add(fechaaAgregar)
      }
    }

    public void quitarPosibleFecha(Date fecha){
      Fecha fechaaAgregar = new Fecha(fecha)
      def fechaAnterior = this.fechas.find { i -> i == fechaaAgregar }
      if (!fechaAnterior){
        throw new IllegalArgumentException("La fecha no se encuentra entre las posibles")
      }
      if (fechaAnterior.estavotada()){
        fechaAnterior.desvotar()
      }
      else{fecha.removeElement(fecha)
      }

    }
    static constraints = {
    }
}
