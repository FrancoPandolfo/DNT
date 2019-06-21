package organizadordeeventos


class Proveedor {

    String nombre
    //nombre elemento cantidad y costo
    Set<Item> compras = []
    Dinero costoTotal

    Proveedor(String name){
        nombre = name
    }

    def getCostoTotal(){
        return costoTotal.getCantidad()
    }

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