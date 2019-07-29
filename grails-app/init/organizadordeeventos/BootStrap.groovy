package organizadordeeventos

class BootStrap {

    def init = { servletContext ->
      Usuario admin1 = new Usuario(nombre:'Franco',apellido: 'Fernandez Pandolfo',mail:'francopandolfo@hotmail.com',username: 'Franco', password: 'dnt2019',enabled: true).save()
        Usuario admin2 = new Usuario(nombre:'Augusto',apellido:'Lizarraga Marin',mail:'augusjoa@gmail.com',username: 'Augusto', password: 'dnt2019',enabled: true).save()
        Usuario usuario1 = new Usuario(nombre:'Mauro',apellido:'Ciancio', mail:'maurociancio@gmail.com',username: 'Mauro',password: '123',enabled: true).save()
        Usuario usuario2 = new Usuario(nombre:'Marcos',apellido: 'Saladino',mail: 'marcos.saladino@gmail.com',username: 'Marcos',password: '345',enabled: true).save()

        /*
        new Usuario(nombre:'Franco',apellido: 'Fernandez Pandolfo',mail:'francopandolfo@hotmail.com').save()
        new Usuario(nombre:'Augusto',apellido:'Lizarraga Marin',mail:'augusjoa@gmail.com').save()
        new Usuario(nombre:'Mauro',apellido:'Ciancio', mail:'maurociancio@gmail.com').save()
        new Usuario(nombre:'Marcos',apellido: 'Saladino',mail: 'marcos.saladino@gmail.com').save()
        new Usuario(nombre:'Pablo',apellido:'Cosso',mail:'pablocosso@gmail.com').save()
         */

        Role admin = new Role(authority: 'ROLE_ADMIN').save()
        Role comun = new Role(authority: 'ROLE_COMUN').save()

        UserRole.create(admin1,admin)
        UserRole.create(admin2,admin)
        UserRole.create(usuario1,comun)
        UserRole.create(usuario2,comun)

    }
    def destroy = {
    }
}
