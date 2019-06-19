package organizadordeeventos

class Item {
    String nombre
    Integer cantidad
    Integer costo
    Tipo tipo

    enum Tipo{
        COMIDA,BEBIDA,INFRAESTRUCTURA,OTROS
    }

    static constraints = {
    }
}
