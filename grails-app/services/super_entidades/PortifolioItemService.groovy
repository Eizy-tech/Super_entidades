package super_entidades

import grails.gorm.services.Service

@Service(PortifolioItem)
interface PortifolioItemService {

    PortifolioItem get(Serializable id)

    List<PortifolioItem> list(Map args)

    Long count()

    void delete(Serializable id)

    PortifolioItem save(PortifolioItem portifolioItem)

}