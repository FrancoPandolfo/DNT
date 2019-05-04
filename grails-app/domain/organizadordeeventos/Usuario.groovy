package organizadordeeventos

class Usuario {

    String nombre
    String mail
    Evento evento

    static constraints = {

        nombre blank: false, nullable: false
        mail blank: false, nullable: false, mail: true

    }
}