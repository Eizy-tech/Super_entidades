package super_entidades

import grails.gorm.services.Service

@Service(EntidadePacote)
interface EntidadePacoteService {

    EntidadePacote get(Serializable id)

    List<EntidadePacote> list(Map args)

    Long count()

    void delete(Serializable id)

    EntidadePacote save(EntidadePacote entidadePacote)

}