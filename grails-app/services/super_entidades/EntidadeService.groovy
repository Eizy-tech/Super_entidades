package super_entidades

import grails.gorm.services.Service

@Service(Entidade)
interface EntidadeService {

    Entidade get(Serializable id)

    List<Entidade> list(Map args)

    Long count()

    void delete(Serializable id)

    Entidade save(Entidade entidade)

}