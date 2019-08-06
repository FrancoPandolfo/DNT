package organizadordeeventos

class PosiblesFechas {
    private Set<Fecha> fechas = []

    public Fecha agregarPosibleFecha(Date fecha){
      Fecha fechaaAgregar = new Fecha(fecha)
      def fechaAnterior = this.fechas.find { i -> i == fechaaAgregar }
      if (fechaAnterior){
        fechaAnterior.votar()
        return fechaAnterior
      }

      fechas.add(fechaaAgregar)
      return fechaaAgregar
    }

    public void quitarPosibleFecha(Date fecha){
      Fecha fechaaQuitar = new Fecha(fecha)
      def fechaAnterior = this.fechas.find { i -> i == fechaaQuitar }
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
