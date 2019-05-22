package organizadordeeventos

class CalculadorGastos {

    //REVISAR SI ESTA BIEN PASAR gastoTotal
    def calculoAgregarCompra(Presupuesto presupuesto, Item compra,Integer gastoTotal){
        gastoTotal += compra.costo
        presupuesto.remanente -= compra.costo
    }

    def calculoQuitarProveedor(Presupuesto presupuesto, Proveedor proveedor,Integer gastoTotal){
        gastoTotal -= proveedor.costoTotal
        presupuesto.remanente += proveedor.costoTotal
    }

    def calculoAgregarInfraestructura(Presupuesto presupuesto, Item infra,Integer gastoTotal){
        gastoTotal += infra.costo
        presupuesto.remanente -= infra.costo
    }

    def calculoQuitarInfraestructura(Presupuesto presupuesto, Item infra,Integer gastoTotal){
        gastoTotal -= infra.costo
        presupuesto.remanente += infra.costo
    }


    static constraints = {
    }
}
