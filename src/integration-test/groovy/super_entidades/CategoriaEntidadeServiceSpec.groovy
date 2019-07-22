package super_entidades

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CategoriaEntidadeServiceSpec extends Specification {

    CategoriaEntidadeService categoriaEntidadeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CategoriaEntidade(...).save(flush: true, failOnError: true)
        //new CategoriaEntidade(...).save(flush: true, failOnError: true)
        //CategoriaEntidade categoriaEntidade = new CategoriaEntidade(...).save(flush: true, failOnError: true)
        //new CategoriaEntidade(...).save(flush: true, failOnError: true)
        //new CategoriaEntidade(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //categoriaEntidade.id
    }

    void "test get"() {
        setupData()

        expect:
        categoriaEntidadeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CategoriaEntidade> categoriaEntidadeList = categoriaEntidadeService.list(max: 2, offset: 2)

        then:
        categoriaEntidadeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        categoriaEntidadeService.count() == 5
    }

    void "test delete"() {
        Long categoriaEntidadeId = setupData()

        expect:
        categoriaEntidadeService.count() == 5

        when:
        categoriaEntidadeService.delete(categoriaEntidadeId)
        sessionFactory.currentSession.flush()

        then:
        categoriaEntidadeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CategoriaEntidade categoriaEntidade = new CategoriaEntidade()
        categoriaEntidadeService.save(categoriaEntidade)

        then:
        categoriaEntidade.id != null
    }
}
