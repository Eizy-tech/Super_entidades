package super_entidades

import grails.gorm.services.Service

@Service(CategoriaEntidade)
interface CategoriaEntidadeService {

    CategoriaEntidade get(Serializable id)

    List<CategoriaEntidade> list(Map args)

    Long count()

    void delete(Serializable id)

    CategoriaEntidade save(CategoriaEntidade categoriaEntidade)

}