package organizadordeeventos


class InfoEvento {

    Integer presupuesto
    Integer cantidadInvitados
    Integer costoTotal
    Integer presupuestoRestante
    String lugar

    static constraints = {

        presupuesto blank:false, nullable:false, min: 0
        lugar blank:false, nullable:false

    }
}