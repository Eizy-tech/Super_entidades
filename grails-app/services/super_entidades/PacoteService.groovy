package super_entidades

import grails.gorm.services.Service

@Service(Pacote)
interface PacoteService {

    Pacote get(Serializable id)

    List<Pacote> list(Map args)

    Long count()

    void delete(Serializable id)

    Pacote save(Pacote pacote)

}