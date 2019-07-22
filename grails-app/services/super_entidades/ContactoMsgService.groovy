package super_entidades

import grails.gorm.services.Service

@Service(ContactoMsg)
interface ContactoMsgService {

    ContactoMsg get(Serializable id)

    List<ContactoMsg> list(Map args)

    Long count()

    void delete(Serializable id)

    ContactoMsg save(ContactoMsg contactoMsg)

}