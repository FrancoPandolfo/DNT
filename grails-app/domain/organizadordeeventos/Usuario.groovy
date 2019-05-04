package organizadordeeventos

class Usuario {

    String nombre
    String apellido
    String mail
    Evento evento

    static constraints = {

        nombre blank: false, nullable: false
        apellido blank: false, nullable: false
        mail blank: false, nullable: false, mail: true

    }
}