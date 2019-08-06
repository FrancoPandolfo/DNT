package organizadordeeventos

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FechaServiceSpec extends Specification {

    FechaService fechaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Fecha(...).save(flush: true, failOnError: true)
        //new Fecha(...).save(flush: true, failOnError: true)
        //Fecha fecha = new Fecha(...).save(flush: true, failOnError: true)
        //new Fecha(...).save(flush: true, failOnError: true)
        //new Fecha(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //fecha.id
    }

    void "test get"() {
        setupData()

        expect:
        fechaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Fecha> fechaList = fechaService.list(max: 2, offset: 2)

        then:
        fechaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        fechaService.count() == 5
    }

    void "test delete"() {
        Long fechaId = setupData()

        expect:
        fechaService.count() == 5

        when:
        fechaService.delete(fechaId)
        sessionFactory.currentSession.flush()

        then:
        fechaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Fecha fecha = new Fecha()
        fechaService.save(fecha)

        then:
        fecha.id != null
    }
}
