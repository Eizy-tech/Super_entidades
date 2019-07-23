package super_entidades

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class UtilizadorRoleServiceSpec extends Specification {

    UtilizadorRoleService utilizadorRoleService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new UtilizadorRole(...).save(flush: true, failOnError: true)
        //new UtilizadorRole(...).save(flush: true, failOnError: true)
        //UtilizadorRole utilizadorRole = new UtilizadorRole(...).save(flush: true, failOnError: true)
        //new UtilizadorRole(...).save(flush: true, failOnError: true)
        //new UtilizadorRole(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //utilizadorRole.id
    }

    void "test get"() {
        setupData()

        expect:
        utilizadorRoleService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<UtilizadorRole> utilizadorRoleList = utilizadorRoleService.list(max: 2, offset: 2)

        then:
        utilizadorRoleList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        utilizadorRoleService.count() == 5
    }

    void "test delete"() {
        Long utilizadorRoleId = setupData()

        expect:
        utilizadorRoleService.count() == 5

        when:
        utilizadorRoleService.delete(utilizadorRoleId)
        sessionFactory.currentSession.flush()

        then:
        utilizadorRoleService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        UtilizadorRole utilizadorRole = new UtilizadorRole()
        utilizadorRoleService.save(utilizadorRole)

        then:
        utilizadorRole.id != null
    }
}
