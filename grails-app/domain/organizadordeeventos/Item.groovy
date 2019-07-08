package organizadordeeventos
import organizadordeeventos.Dinero

class Item {
    String nombre
    Integer cantidad
    Dinero costo
    Tipo tipo

    //actualmete el costo se va a pasar por parametro, la idea es que lo calcule el proveedor.
    Item(String nombre, Integer cantidad, BigDecimal cost, Tipo tipo){
        this.nombre = nombre
        this.cantidad = cantidad
        Dinero costo = new Dinero(cost)
        this.costo = costo
        this.tipo = tipo
    }

    def getCosto(){
      this.costo
    }

    enum Tipo{
        COMIDA,BEBIDA,INFRAESTRUCTURA,OTROS
    }

    static constraints = {
      nombre blank:false, nullable:false
      cantidad blank:false, nullable:false, min: 0
      costo blank:false, nullable:false
    }
}
