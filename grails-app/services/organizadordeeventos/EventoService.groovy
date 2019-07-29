package organizadordeeventos

import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

@Service(Evento)
abstract class EventoService {

  protected abstract Evento get(Serializable id)

  protected abstract List<Evento> list(Map args)

  protected abstract Long count()

  protected abstract void delete(Serializable id)

  protected abstract Evento save(Evento evento)
}
