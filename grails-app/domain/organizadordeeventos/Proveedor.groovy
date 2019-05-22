package organizadordeeventos


class Proveedor {

    String nombre
    //nombre elemento cantidad y costo
    Set<Item> compra = []
    //def comida = [:]
    //def bebida = [:]
    Integer costoTotal

    Proveedor(String name){
        nombre = name
    }


    def nuevaCompra(){
    }
/*
    //calcula el costo total del proveedor
    def calcularCostoTotal(){
        costoTotal = 0
        for (costo in compra){
            costoTotal += costo.value[1]
        }
    }
*/
}