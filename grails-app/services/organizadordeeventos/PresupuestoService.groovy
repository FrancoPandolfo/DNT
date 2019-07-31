package organizadordeeventos
import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

@Service(Presupuesto)
abstract class PresupuestoService {
  protected abstract Presupuesto get(Serializable id)

  protected abstract List<Presupuesto> list(Map args)

  protected abstract Long count()

  protected abstract void delete(Serializable id)

  protected abstract Presupuesto save(Presupuesto presupuesto)

}
