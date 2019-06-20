package organizadordeeventos

class Usuario {

    //aca podria guardar en que eventos es administrador. COMO?
    //cuando entra a un evento que no es administrador no cambia su estado
    //de usuario a administrador
    String nombre
    String apellido
    String mail
    Set<Evento> eventos = []
    Set<Proveedor> proveedores = []
    Buscador buscador

    Usuario(String name, String sername, String email){
        nombre = name
        apellido = sername
        mail = email
    }

    //cuando crea el evento se vuelve admin del evento
    def crearEvento(String nombre){
        Evento evento = new Evento(nombre)
        eventos.add(evento)
        Administrador admin = new Administrador(this, evento)
        evento.usuarios.add(this)
        evento.administradores.add(admin)
    }

    cargarProveedor(String nombre){
        Proveedor proveedor = new Proveedor(nombre)
        proveedores.add(proveedor)
    }


    def agregarEvento(Evento evento){
        eventos.add(evento)
    }

    def quitarEvento(Evento evento){
        //Evento evento = buscador.buscarEvento(name,eventos)
        //if(evento == null){throw new IllegalArgumentException("no se encontro evento con ese nombre")}
        eventos.removeElement(evento)
    }


    static hasMany=[
            eventos:Evento,
            proveedores:Proveedor
    ]

    static constraints = {

        nombre blank: false, nullable: false
        apellido blank: false, nullable: false
        mail blank: false, nullable: false, mail: true

    }
}