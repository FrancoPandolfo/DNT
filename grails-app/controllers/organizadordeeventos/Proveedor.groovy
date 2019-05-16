package organizadordeeventos

class Proveedor {

    String nombre
    //nombre elemento cantidad y costo
    Map<String, Tuple> compra = new HashMap<>()
    //def comida = [:]
    //def bebida = [:]
    Integer costoTotal

    //falta hacer el constructor?

    //calcula el costo total del proveedor
    def calcularCostoTotal(){
        costoTotal = 0
        for (costo in compra){
            costoTotal += costo.value[1]
        }
    }

}
