package organizadordeeventos

class Usuario {

    //aca podria guardar en que eventos es administrador. COMO?
    //cuando entra a un evento que no es administrador no cambia su estado
    //de usuario a administrador
    String nombre
    String apellido
    String mail
    Set<Evento> eventos = []
    Buscador buscador

    //falta hacer el constructor?

    //cuando crea el evento se vuelve admin del evento
    def crearEvento(){

    }

    def agregarEvento(Evento evento){
        eventos.add(evento)
    }

    def quitarEvento(String name){
        Evento evento = buscador.buscarEvento(name,eventos)
        if(evento == null){throw new IllegalArgumentException("no se encontro evento con ese nombre")}
        eventos.removeElement(evento)
    }


    static hasMany=[
            eventos:Evento
    ]

    static constraints = {

        nombre blank: false, nullable: false
        apellido blank: false, nullable: false
        mail blank: false, nullable: false, mail: true

    }
}