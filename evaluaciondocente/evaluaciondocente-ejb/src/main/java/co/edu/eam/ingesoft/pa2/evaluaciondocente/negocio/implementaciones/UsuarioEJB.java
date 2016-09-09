package co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.exepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.interfaces.IUsuarioEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Usuario;

@LocalBean
@Stateless
@Remote(IUsuarioEJB.class)
public class UsuarioEJB extends EJBGenerico<Usuario> implements IUsuarioEJB {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void crear (Usuario usuario) throws ExcepcionNegocio {
		if (buscar(usuario.getId()) != null) {
			throw new ExcepcionNegocio("Ya existe un usuario con el mismo id");
		} else {
			dao.crear(usuario);
		}
	}
	
	public Usuario buscar (Object id) {
		return dao.buscar(Usuario.class,id);
	}
	
	public void editar (Usuario usuario) throws ExcepcionNegocio {
		dao.editar(usuario);
	}
	
	public void eliminar (Usuario usuario) throws ExcepcionNegocio {
		dao.borrar(usuario);
	}
	
	public Usuario buscarUsuarioNickname(String nickname) throws ExcepcionNegocio {
		if(dao.ejecutarNamedQuery(Usuario.BUSCAR_NICKNAME, nickname).isEmpty()){
			return null;
		} else {
			return (Usuario) dao.ejecutarNamedQuery(Usuario.BUSCAR_NICKNAME, nickname).get(0);
		}		
	}
}