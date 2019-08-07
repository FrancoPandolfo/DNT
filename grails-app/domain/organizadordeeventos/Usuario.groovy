package organizadordeeventos

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class Usuario implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password

    String nombre
    String apellido
    String mail
    Set<Evento> eventos = []
    Set<Proveedor> proveedores = []

    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Usuario(String nombre, String apellido, String mail){
        this.nombre = nombre
        this.apellido = apellido
        this.mail = mail
    }

    //cuando crea el evento se vuelve admin del evento
    def crearEvento(String nombre){
        Evento evento = new Evento(nombre)
        evento.save(failOnError:true)
        eventos.add(evento)
        new Administrador(this, evento).save()
        //evento.usuarios.add(this)
        //evento.administradores.add(admin)
    }

    def cargarProveedor(String nombre){
        Dinero costoInicial = new Dinero(0.0)
        Proveedor proveedor = new Proveedor(nombre,costoInicial)
        proveedores.add(proveedor)
        proveedor.save(failOnError:true)
    }

    def quitarProveedor(Proveedor proveedor){
        proveedores.removeElement(proveedor)
    }

    def agregarEvento(Evento evento){
        eventos.add(evento)
    }

    def quitarEvento(Evento evento){
        //Evento evento = buscador.buscarEvento(name,eventos)
        //if(evento == null){throw new IllegalArgumentException("no se encontro evento con ese nombre")}
        eventos.removeElement(evento)
    }


    Set<Role> getAuthorities() {
        (UsuarioRole.findAllByUsuario(this) as List<UsuarioRole>)*.role as Set<Role>
    }


    static hasMany=[
            eventos:Evento,
            proveedores:Proveedor
    ]

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
        //nombre blank: false, nullable: false
        //apellido blank: false, nullable: false
        //mail blank: false, nullable: false, mail: true
    }

    static mapping = {
	    password column: '`password`'
    }
}
