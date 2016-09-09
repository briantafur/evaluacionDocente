package co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Rol;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Usuario;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.UsuarioRol;

@LocalBean
@Stateless
public class RolEJB extends EJBGenerico<Rol> {
	
	@Override
	public Class getClase() {
		return null;
	}
	
	public List<Rol> listar(Usuario usuario) {
		return dao.ejecutarNamedQuery(UsuarioRol.LISTAR, usuario);
	}

}
