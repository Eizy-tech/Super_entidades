package super_entidades

import grails.gorm.services.Service

@Service(UtilizadorRole)
interface UtilizadorRoleService {

    UtilizadorRole get(Serializable id)

    List<UtilizadorRole> list(Map args)

    Long count()

    void delete(Serializable id)

    UtilizadorRole save(UtilizadorRole utilizadorRole)

}