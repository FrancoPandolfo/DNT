package organizadordeeventos


class Proveedor {

    String nombre
    //nombre elemento cantidad y costo
    Set<Item> compras = []
    Dinero costoTotal

    Proveedor(String name){
        nombre = name
        Dinero costo = new Dinero(0.0)
        costoTotal = costo
    }


    //def getCostoTotal(){
    //}

    def nuevaCompra(Item compra){
        compras.add(compra)
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