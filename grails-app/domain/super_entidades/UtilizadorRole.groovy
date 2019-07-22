package super_entidades

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.codehaus.groovy.util.HashCodeHelper
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@ToString(cache=true, includeNames=true, includePackage=false)
class UtilizadorRole implements Serializable {

	private static final long serialVersionUID = 1

	Utilizador utilizador
	Role role

	@Override
	boolean equals(other) {
		if (other instanceof UtilizadorRole) {
			other.utilizadorId == utilizador?.id && other.roleId == role?.id
		}
	}

    @Override
	int hashCode() {
	    int hashCode = HashCodeHelper.initHash()
        if (utilizador) {
            hashCode = HashCodeHelper.updateHash(hashCode, utilizador.id)
		}
		if (role) {
		    hashCode = HashCodeHelper.updateHash(hashCode, role.id)
		}
		hashCode
	}

	static UtilizadorRole get(long utilizadorId, long roleId) {
		criteriaFor(utilizadorId, roleId).get()
	}

	static boolean exists(long utilizadorId, long roleId) {
		criteriaFor(utilizadorId, roleId).count()
	}

	private static DetachedCriteria criteriaFor(long utilizadorId, long roleId) {
		UtilizadorRole.where {
			utilizador == Utilizador.load(utilizadorId) &&
			role == Role.load(roleId)
		}
	}

	static UtilizadorRole create(Utilizador utilizador, Role role, boolean flush = false) {
		def instance = new UtilizadorRole(utilizador: utilizador, role: role)
		instance.save(flush: flush)
		instance
	}

	static boolean remove(Utilizador u, Role r) {
		if (u != null && r != null) {
			UtilizadorRole.where { utilizador == u && role == r }.deleteAll()
		}
	}

	static int removeAll(Utilizador u) {
		u == null ? 0 : UtilizadorRole.where { utilizador == u }.deleteAll() as int
	}

	static int removeAll(Role r) {
		r == null ? 0 : UtilizadorRole.where { role == r }.deleteAll() as int
	}

	static constraints = {
	    utilizador nullable: false
		role nullable: false, validator: { Role r, UtilizadorRole ur ->
			if (ur.utilizador?.id) {
				if (UtilizadorRole.exists(ur.utilizador.id, r.id)) {
				    return ['userRole.exists']
				}
			}
		}
	}

	static mapping = {
		id composite: ['utilizador', 'role']
//		version false
	}
}
