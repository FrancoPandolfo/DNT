package organizadordeeventos

import grails.gorm.transactions.Transactional

@Transactional
class PruebaConEventoService {

    def agregar(Long eventoId,BigDecimal presupuesto) {
        Evento evento = Evento.get(eventoId)
        assert evento != null
        Dinero presupuestoAux = new Dinero(presupuesto)
        Evento.presupuesto = presupuestoAux

    }

}
