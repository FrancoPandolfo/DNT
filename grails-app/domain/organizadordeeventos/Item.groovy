package organizadordeeventos

class Item {
    String nombre
    Integer cantidad
    Dinero costo
    Tipo tipo

    //actualmete el costo se va a pasar por parametro, la idea es que lo calcule el proveedor.
    Item(String name, Integer cant, Integer cost, Tipo type){
        nombre = name
        cantidad = cant
        costo.setCantidad(cost)
        tipo = type
    }

    getCosto(){
        return costo
    }
    enum Tipo{
        COMIDA,BEBIDA,INFRAESTRUCTURA,OTROS
    }

    static constraints = {
    }
}
