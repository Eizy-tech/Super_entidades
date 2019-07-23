package super_entidades

import grails.gorm.services.Service

@Service(Auditoria)
interface AuditoriaService {

    Auditoria get(Serializable id)

    List<Auditoria> list(Map args)

    Long count()

    void delete(Serializable id)

    Auditoria save(Auditoria auditoria)

}