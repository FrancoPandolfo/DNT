package organizadordeeventos

import grails.gorm.transactions.Transactional

@Transactional
class PruebaUnoService {

  def agregarEvento(Usuario usuario, Evento evento){
      usuario.eventos.add(evento)
      usuario.save()
  }
}
