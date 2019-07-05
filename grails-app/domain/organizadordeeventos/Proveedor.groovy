package organizadordeeventos


class Proveedor {

    String nombre
    //nombre elemento cantidad y costo
    Set<Item> compras = []
    Dinero costoTotal

    Proveedor(String nombre){
        this.nombre = nombre
        Dinero costo = new Dinero(0.0)
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
