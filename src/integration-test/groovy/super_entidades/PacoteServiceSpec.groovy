package super_entidades

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PacoteServiceSpec extends Specification {

    PacoteService pacoteService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Pacote(...).save(flush: true, failOnError: true)
        //new Pacote(...).save(flush: true, failOnError: true)
        //Pacote pacote = new Pacote(...).save(flush: true, failOnError: true)
        //new Pacote(...).save(flush: true, failOnError: true)
        //new Pacote(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //pacote.id
    }

    void "test get"() {
        setupData()

        expect:
        pacoteService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Pacote> pacoteList = pacoteService.list(max: 2, offset: 2)

        then:
        pacoteList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        pacoteService.count() == 5
    }

    void "test delete"() {
        Long pacoteId = setupData()

        expect:
        pacoteService.count() == 5

        when:
        pacoteService.delete(pacoteId)
        sessionFactory.currentSession.flush()

        then:
        pacoteService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Pacote pacote = new Pacote()
        pacoteService.save(pacote)

        then:
        pacote.id != null
    }
}
