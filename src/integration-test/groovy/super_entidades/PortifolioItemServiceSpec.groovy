package super_entidades

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PortifolioItemServiceSpec extends Specification {

    PortifolioItemService portifolioItemService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PortifolioItem(...).save(flush: true, failOnError: true)
        //new PortifolioItem(...).save(flush: true, failOnError: true)
        //PortifolioItem portifolioItem = new PortifolioItem(...).save(flush: true, failOnError: true)
        //new PortifolioItem(...).save(flush: true, failOnError: true)
        //new PortifolioItem(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //portifolioItem.id
    }

    void "test get"() {
        setupData()

        expect:
        portifolioItemService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PortifolioItem> portifolioItemList = portifolioItemService.list(max: 2, offset: 2)

        then:
        portifolioItemList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        portifolioItemService.count() == 5
    }

    void "test delete"() {
        Long portifolioItemId = setupData()

        expect:
        portifolioItemService.count() == 5

        when:
        portifolioItemService.delete(portifolioItemId)
        sessionFactory.currentSession.flush()

        then:
        portifolioItemService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PortifolioItem portifolioItem = new PortifolioItem()
        portifolioItemService.save(portifolioItem)

        then:
        portifolioItem.id != null
    }
}
