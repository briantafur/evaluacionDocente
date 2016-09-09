package co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.exepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.interfaces.IDecanoEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Decano;

@LocalBean
@Stateless
@Remote(IDecanoEJB.class)
public class DecanoEJB extends EJBGenerico<Decano> implements IDecanoEJB {
	
	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Decano.class;
	}
	
	public void crear (Decano decano) throws ExcepcionNegocio {
		if (buscar(decano.getId()) != null) {
			throw new ExcepcionNegocio("Ya existe un usuario con el mismo id");
		} else {
			dao.crear(decano);
		}
	}
	
	public Decano buscar (Object id) {
		return dao.buscar(Decano.class,id);
	}
	
	public void editar (Decano decano) throws ExcepcionNegocio {
		dao.editar(decano);
	}
	
	public void eliminar (Decano decano) throws ExcepcionNegocio {
		dao.borrar(decano);
	}
}
