package super_entidades

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EntidadeServiceSpec extends Specification {

    EntidadeService entidadeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Entidade(...).save(flush: true, failOnError: true)
        //new Entidade(...).save(flush: true, failOnError: true)
        //Entidade entidade = new Entidade(...).save(flush: true, failOnError: true)
        //new Entidade(...).save(flush: true, failOnError: true)
        //new Entidade(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //entidade.id
    }

    void "test get"() {
        setupData()

        expect:
        entidadeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Entidade> entidadeList = entidadeService.list(max: 2, offset: 2)

        then:
        entidadeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        entidadeService.count() == 5
    }

    void "test delete"() {
        Long entidadeId = setupData()

        expect:
        entidadeService.count() == 5

        when:
        entidadeService.delete(entidadeId)
        sessionFactory.currentSession.flush()

        then:
        entidadeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Entidade entidade = new Entidade()
        entidadeService.save(entidade)

        then:
        entidade.id != null
    }
}
