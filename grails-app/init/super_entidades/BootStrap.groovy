package super_entidades

class BootStrap {

    def init = { servletContext ->

        def admin = Utilizador.findByUsername('admin')
        def adminRole = Role.findOrSaveWhere(authority: 'ROLE_ADMIN')
        if(!admin) {
            admin = new Utilizador(username: 'admin', password: '111111').save()
            new UtilizadorRole(utilizador: admin, role: adminRole).save()
        }
    }
    def destroy = {
    }
}
