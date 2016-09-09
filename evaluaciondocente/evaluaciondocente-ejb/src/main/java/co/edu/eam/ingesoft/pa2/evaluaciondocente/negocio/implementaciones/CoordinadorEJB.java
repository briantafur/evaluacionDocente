package co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.exepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.interfaces.ICoordinadorEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Coordinador;

@LocalBean
@Stateless
@Remote(ICoordinadorEJB.class)
public class CoordinadorEJB extends EJBGenerico<Coordinador> implements ICoordinadorEJB {
	
	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void crear (Coordinador coordinador) throws ExcepcionNegocio {
		if (buscar(coordinador.getId()) != null) {
			throw new ExcepcionNegocio("Ya existe un usuario con el mismo id");
		} else {
			dao.crear(coordinador);
		}
	}
	
	public Coordinador buscar (Object id) {
		return dao.buscar(Coordinador.class,id);
	}
	
	public void editar (Coordinador coordinador) throws ExcepcionNegocio {
		dao.editar(coordinador);
	}
	
	public void eliminar (Coordinador coordinador) throws ExcepcionNegocio {
		dao.borrar(coordinador);
	}
}
