package super_entidades

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ContactoMsgServiceSpec extends Specification {

    ContactoMsgService contactoMsgService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ContactoMsg(...).save(flush: true, failOnError: true)
        //new ContactoMsg(...).save(flush: true, failOnError: true)
        //ContactoMsg contactoMsg = new ContactoMsg(...).save(flush: true, failOnError: true)
        //new ContactoMsg(...).save(flush: true, failOnError: true)
        //new ContactoMsg(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //contactoMsg.id
    }

    void "test get"() {
        setupData()

        expect:
        contactoMsgService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ContactoMsg> contactoMsgList = contactoMsgService.list(max: 2, offset: 2)

        then:
        contactoMsgList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        contactoMsgService.count() == 5
    }

    void "test delete"() {
        Long contactoMsgId = setupData()

        expect:
        contactoMsgService.count() == 5

        when:
        contactoMsgService.delete(contactoMsgId)
        sessionFactory.currentSession.flush()

        then:
        contactoMsgService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ContactoMsg contactoMsg = new ContactoMsg()
        contactoMsgService.save(contactoMsg)

        then:
        contactoMsg.id != null
    }
}
