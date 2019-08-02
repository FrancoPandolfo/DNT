package organizadordeeventos

import grails.gorm.transactions.Transactional

@Transactional
class PruebaUnoService {

   def getUsuarioActual(Long userId){
       Usuario usuario = Usuario.get(userId)
       assert usuario!= null
       return usuario
   }
}
