package organizadordeeventos
import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

@Service(Tarea)
abstract class TareaService {

  protected abstract Tarea get(Serializable id)

  protected abstract List<Tarea> list(Map args)

  protected abstract Long count()

  protected abstract void delete(Serializable id)

  protected abstract Tarea save(Tarea tarea)

  @Transactional
  void completar(Tarea tarea){
    tarea.completar()
  }

  @Transactional
  void enProceso(Tarea tarea){
    tarea.enProceso()
  }

  @Transactional
  void reiniciar(Tarea tarea){
    tarea.reiniciar()
  }

}
