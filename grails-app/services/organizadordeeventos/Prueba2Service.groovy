package organizadordeeventos

import grails.gorm.transactions.Transactional

@Transactional
class Prueba2Service {

    Evento crearUnEvento(Long usuarioId) {
      Usuario usuario = Usuario.get(usuarioId)
      assert usuario != null

      //usuario.crearEvento("d&d")
        new Evento("d&d").save()
        Evento evento = new Evento("d&d")
        assert evento != null
        return evento
    }
}
