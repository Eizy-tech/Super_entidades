package super_entidades

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EntidadePacoteServiceSpec extends Specification {

    EntidadePacoteService entidadePacoteService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new EntidadePacote(...).save(flush: true, failOnError: true)
        //new EntidadePacote(...).save(flush: true, failOnError: true)
        //EntidadePacote entidadePacote = new EntidadePacote(...).save(flush: true, failOnError: true)
        //new EntidadePacote(...).save(flush: true, failOnError: true)
        //new EntidadePacote(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //entidadePacote.id
    }

    void "test get"() {
        setupData()

        expect:
        entidadePacoteService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<EntidadePacote> entidadePacoteList = entidadePacoteService.list(max: 2, offset: 2)

        then:
        entidadePacoteList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        entidadePacoteService.count() == 5
    }

    void "test delete"() {
        Long entidadePacoteId = setupData()

        expect:
        entidadePacoteService.count() == 5

        when:
        entidadePacoteService.delete(entidadePacoteId)
        sessionFactory.currentSession.flush()

        then:
        entidadePacoteService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        EntidadePacote entidadePacote = new EntidadePacote()
        entidadePacoteService.save(entidadePacote)

        then:
        entidadePacote.id != null
    }
}
