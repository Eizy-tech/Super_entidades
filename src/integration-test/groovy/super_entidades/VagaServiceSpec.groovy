package super_entidades

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VagaServiceSpec extends Specification {

    VagaService vagaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Vaga(...).save(flush: true, failOnError: true)
        //new Vaga(...).save(flush: true, failOnError: true)
        //Vaga vaga = new Vaga(...).save(flush: true, failOnError: true)
        //new Vaga(...).save(flush: true, failOnError: true)
        //new Vaga(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vaga.id
    }

    void "test get"() {
        setupData()

        expect:
        vagaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Vaga> vagaList = vagaService.list(max: 2, offset: 2)

        then:
        vagaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vagaService.count() == 5
    }

    void "test delete"() {
        Long vagaId = setupData()

        expect:
        vagaService.count() == 5

        when:
        vagaService.delete(vagaId)
        sessionFactory.currentSession.flush()

        then:
        vagaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Vaga vaga = new Vaga()
        vagaService.save(vaga)

        then:
        vaga.id != null
    }
}
