package organizadordeeventos

class Item {
    String nombre
    Integer cantidad
    Dinero costo
    Tipo tipo

    //actualmete el costo se va a pasar por parametro, la idea es que lo calcule el proveedor.
    Item(String name, Integer cant, BigDecimal cost, Tipo type){
        nombre = name
        cantidad = cant
        costo.setCantidad(cost)
        tipo = type
    }

    def getCosto(){
        return costo.getCantidad()
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
