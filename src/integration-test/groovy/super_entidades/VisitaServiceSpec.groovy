package super_entidades

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VisitaServiceSpec extends Specification {

    VisitaService visitaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Visita(...).save(flush: true, failOnError: true)
        //new Visita(...).save(flush: true, failOnError: true)
        //Visita visita = new Visita(...).save(flush: true, failOnError: true)
        //new Visita(...).save(flush: true, failOnError: true)
        //new Visita(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //visita.id
    }

    void "test get"() {
        setupData()

        expect:
        visitaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Visita> visitaList = visitaService.list(max: 2, offset: 2)

        then:
        visitaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        visitaService.count() == 5
    }

    void "test delete"() {
        Long visitaId = setupData()

        expect:
        visitaService.count() == 5

        when:
        visitaService.delete(visitaId)
        sessionFactory.currentSession.flush()

        then:
        visitaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Visita visita = new Visita()
        visitaService.save(visita)

        then:
        visita.id != null
    }
}
