package super_entidades

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CategoriaVagaServiceSpec extends Specification {

    CategoriaVagaService categoriaVagaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CategoriaVaga(...).save(flush: true, failOnError: true)
        //new CategoriaVaga(...).save(flush: true, failOnError: true)
        //CategoriaVaga categoriaVaga = new CategoriaVaga(...).save(flush: true, failOnError: true)
        //new CategoriaVaga(...).save(flush: true, failOnError: true)
        //new CategoriaVaga(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //categoriaVaga.id
    }

    void "test get"() {
        setupData()

        expect:
        categoriaVagaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CategoriaVaga> categoriaVagaList = categoriaVagaService.list(max: 2, offset: 2)

        then:
        categoriaVagaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        categoriaVagaService.count() == 5
    }

    void "test delete"() {
        Long categoriaVagaId = setupData()

        expect:
        categoriaVagaService.count() == 5

        when:
        categoriaVagaService.delete(categoriaVagaId)
        sessionFactory.currentSession.flush()

        then:
        categoriaVagaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CategoriaVaga categoriaVaga = new CategoriaVaga()
        categoriaVagaService.save(categoriaVaga)

        then:
        categoriaVaga.id != null
    }
}
