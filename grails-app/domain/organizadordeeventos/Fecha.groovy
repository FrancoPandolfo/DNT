package organizadordeeventos

import java.time.LocalDateTime

class Fecha implements Comparable<Turno>{
    LocalDateTime fecha
    int votos

    Fecha(LocalDateTime fecha){
      this.fecha = fecha
      this.votos = 1
    }

    int votar(){
      this.votos += 1
      this.votos
    }

    int desvotar(){
      this.votos -= 1
      this.votos
    }

    void agregarFecha(){
        
    }
    static constraints = {
      fechaYhorario blank:false, nullable:false
    }
