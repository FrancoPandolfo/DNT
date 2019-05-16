package organizadordeeventos


class InfoEvento {

    Integer presupuesto
    //la lista de invitados puede que sirva que este en Evento
    Set<Usuario>invitados=[]
    Integer cantidadInvitados
    Integer costoTotal
    Integer presupuestoRestante
    String lugar

    //falta el constructor?

    static hasMany=[
          usuarios:Usuario
    ]

    static constraints = {

        presupuesto blank:false, nullable:false, min: 0
        lugar blank:false, nullable:false

    }
}