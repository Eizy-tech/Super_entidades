package super_entidades

import grails.gorm.services.Service

@Service(CategoriaVaga)
interface CategoriaVagaService {

    CategoriaVaga get(Serializable id)

    List<CategoriaVaga> list(Map args)

    Long count()

    void delete(Serializable id)

    CategoriaVaga save(CategoriaVaga categoriaVaga)

}