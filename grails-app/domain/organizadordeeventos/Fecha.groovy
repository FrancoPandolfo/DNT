package organizadordeeventos

import java.time.LocalDateTime

class Fecha implements Comparable<Fecha>{
    LocalDateTime fecha
    int votos

    Fecha(LocalDateTime fecha){
      this.fecha = fecha
      this.votos = 1
    }

    boolean estavotada(){
      this.votos > 1
    }

    int votar(){
      this.votos += 1
      this.votos
    }

    int desvotar(){
      this.votos -= 1
      this.votos
    }


    static constraints = {
      fecha blank:false, nullable:false
    }

    @Override
    int compareTo(Fecha otraFecha){
      return this.fecha <=> otraFecha.fecha
    }
}
