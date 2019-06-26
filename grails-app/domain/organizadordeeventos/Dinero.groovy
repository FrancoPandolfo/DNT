package organizadordeeventos
import java.text.DecimalFormat
class Dinero implements Comparable<Dinero>, Serializable {

    BigDecimal cantidad

    Dinero(BigDecimal cantidad){
      if (cantidad < 0) {
        throw new IllegalArgumentException("Monto negativo")
      }
      this.cantidad = cantidad
    }

    @Override
    int compareTo(Dinero that){
      int iguales = 0
      int comparacion = this.cantidad.compareTo(that.cantidad)
      if(comparacion != iguales) comparacion
      iguales
    }

    Dinero plus(Dinero otro){
      new Dinero(this.cantidad + otro.cantidad)
    }

    Dinero minus(Dinero otro){
        new Dinero(this.cantidad - otro.cantidad)
    }
    static constraints = {
      cantidad blank: false, nullable: false
    }
}
