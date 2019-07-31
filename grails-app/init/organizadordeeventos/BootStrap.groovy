package organizadordeeventos

class BootStrap {

    def init = { servletContext ->

        Role admin = new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
        Role comun = new Role(authority: 'ROLE_COMUN').save(failOnError: true)

        Usuario admin1 = new Usuario(nombre:'Franco',apellido: 'Fernandez Pandolfo',mail:'francopandolfo@hotmail.com',username: 'Franco', password: 'dnt2019').save(failOnError: true)
        Usuario admin2 = new Usuario(nombre:'Augusto',apellido:'Lizarraga Marin',mail:'augusjoa@gmail.com',username: 'Augusto', password: 'dnt2019').save(failOnError: true)
        Usuario usuario2 = new Usuario(nombre:'Marcos',apellido: 'Saladino',mail: 'marcos.saladino@gmail.com',username: 'Marcos',password: '345').save(failOnError: true)
        Usuario usuario1 = new Usuario(nombre:'Mauro',apellido:'Ciancio', mail:'maurociancio@gmail.com',username: 'Mauro',password: '123').save(failOnError: true)

        /*
        new Usuario(nombre:'Franco',apellido: 'Fernandez Pandolfo',mail:'francopandolfo@hotmail.com').save()
        new Usuario(nombre:'Augusto',apellido:'Lizarraga Marin',mail:'augusjoa@gmail.com').save()
        new Usuario(nombre:'Mauro',apellido:'Ciancio', mail:'maurociancio@gmail.com').save()
        new Usuario(nombre:'Marcos',apellido: 'Saladino',mail: 'marcos.saladino@gmail.com').save()
        new Usuario(nombre:'Pablo',apellido:'Cosso',mail:'pablocosso@gmail.com').save()
         */


        UserRole.create(admin1,admin)
        UserRole.create(admin2,admin)
        UserRole.create(usuario1,comun)
        UserRole.create(usuario2,comun)

        UserRole.withSession {
          it.flush()
          it.clear()
        }

    }
    def destroy = {
    }
}
