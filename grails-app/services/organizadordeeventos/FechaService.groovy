package organizadordeeventos

import grails.gorm.services.Service

@Service(Fecha)
interface FechaService {

    Fecha get(Serializable id)

    List<Fecha> list(Map args)

    Long count()

    void delete(Serializable id)

    Fecha save(Fecha fecha)

}