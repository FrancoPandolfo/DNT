package organizadordeeventos


class Proveedor {

    String nombre
    Set<Item> compras = []
    Dinero costoTotal

    Proveedor(String nombre, Dinero costo){
        this.nombre = nombre
        this.costoTotal = costo
    }


    def getCostoTotal(){
      this.costoTotal
    }

    def nuevaCompra(Item compra){
        compras.add(compra)
        costoTotal = costoTotal + compra.costo
    }

    def eliminarCompra(Item compra){
        compras.removeElement(compra)
        costoTotal = costoTotal - compra.costo
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
