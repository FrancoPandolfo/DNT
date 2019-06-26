package organizadordeeventos
import java.text.DecimalFormat
@groovy.transform.Tostring
@groovy.transform.EqualsAndHashCode
class Dinero implements Comparable<Dinero>, Serializable {

    BigDecimal cantidad

    Dinero(BigDecimal cantidad){
      if (monto < 0) {
        throw new IllegalArgumentException("Monto negativo")
      }
      this.cantidad = cantidad
    }

    @Override
    int compareTo(Dinero that){
      int iguales = 0
      int comparacion = this.monto.compareTo(that.monto)
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
      cantidad blank: false, nullable: false, min
    }
}
