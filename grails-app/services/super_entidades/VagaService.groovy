package super_entidades

import grails.gorm.services.Service

@Service(Vaga)
interface VagaService {

    Vaga get(Serializable id)

    List<Vaga> list(Map args)

    Long count()

    void delete(Serializable id)

    Vaga save(Vaga vaga)

}