package organizadordeeventos

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PosiblesFechasServiceSpec extends Specification {

    PosiblesFechasService posiblesFechasService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PosiblesFechas(...).save(flush: true, failOnError: true)
        //new PosiblesFechas(...).save(flush: true, failOnError: true)
        //PosiblesFechas posiblesFechas = new PosiblesFechas(...).save(flush: true, failOnError: true)
        //new PosiblesFechas(...).save(flush: true, failOnError: true)
        //new PosiblesFechas(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //posiblesFechas.id
    }

    void "test get"() {
        setupData()

        expect:
        posiblesFechasService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PosiblesFechas> posiblesFechasList = posiblesFechasService.list(max: 2, offset: 2)

        then:
        posiblesFechasList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        posiblesFechasService.count() == 5
    }

    void "test delete"() {
        Long posiblesFechasId = setupData()

        expect:
        posiblesFechasService.count() == 5

        when:
        posiblesFechasService.delete(posiblesFechasId)
        sessionFactory.currentSession.flush()

        then:
        posiblesFechasService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PosiblesFechas posiblesFechas = new PosiblesFechas()
        posiblesFechasService.save(posiblesFechas)

        then:
        posiblesFechas.id != null
    }
}
