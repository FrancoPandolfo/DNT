package organizadordeeventos

import java.time.LocalDateTime
import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

@Service(PosiblesFechas)
abstract class PosiblesFechasService {

    @Transactional
    public void agregarFecha(Long id, List<LocalDateTime> fechas){
      PosiblesFechas posiblesFechas = get(Id)
      fechas.each{ f ->
        Fecha fecha = posiblesFechas.agregarPosibleFecha(f)
        fecha.save(failOnError)
      }
    }


    protected abstract PosiblesFechas get(Serializable id)

    protected abstract List<PosiblesFechas> list(Map args)

    protected abstract Long count()

    protected abstract void delete(Serializable id)

    protected abstract PosiblesFechas save(PosiblesFechas posiblesFechas)

}
