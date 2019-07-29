package organizadordeeventos

import grails.gorm.transactions.Transactional

@Transactional
class Prueba3Service {
    def register(nuevoUsuario){
      try{
        def rolUsuario = new Role(authority: 'ROLE_COMUN').save(flush: true)
        nuevoUsuario.save(flush: true, failOnError: true)
        UserRole.create(nuevoUsuario, rolUsuario, true)

        return true

      }
      catch(all){
        all.printStackTrace()
        return false
      }
}


    def serviceMethod() {

    }
}
