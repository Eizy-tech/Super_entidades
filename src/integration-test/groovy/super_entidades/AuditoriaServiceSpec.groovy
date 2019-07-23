package super_entidades

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AuditoriaServiceSpec extends Specification {

    AuditoriaService auditoriaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Auditoria(...).save(flush: true, failOnError: true)
        //new Auditoria(...).save(flush: true, failOnError: true)
        //Auditoria auditoria = new Auditoria(...).save(flush: true, failOnError: true)
        //new Auditoria(...).save(flush: true, failOnError: true)
        //new Auditoria(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //auditoria.id
    }

    void "test get"() {
        setupData()

        expect:
        auditoriaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Auditoria> auditoriaList = auditoriaService.list(max: 2, offset: 2)

        then:
        auditoriaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        auditoriaService.count() == 5
    }

    void "test delete"() {
        Long auditoriaId = setupData()

        expect:
        auditoriaService.count() == 5

        when:
        auditoriaService.delete(auditoriaId)
        sessionFactory.currentSession.flush()

        then:
        auditoriaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Auditoria auditoria = new Auditoria()
        auditoriaService.save(auditoria)

        then:
        auditoria.id != null
    }
}
