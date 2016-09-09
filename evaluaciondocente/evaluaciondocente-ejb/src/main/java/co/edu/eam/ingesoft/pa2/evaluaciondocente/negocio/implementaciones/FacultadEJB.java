package co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.interfaces.IFacultadEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Facultad;

@LocalBean
@Stateless
@Remote(IFacultadEJB.class)
public class FacultadEJB extends EJBGenerico<Facultad> implements IFacultadEJB {

	@Override
	public Class getClase() {
		return Facultad.class;
	}
	
	public void crear(Facultad facultad) {
		dao.crear(facultad);
	}
	
	public Facultad buscar(String id){
		return dao.buscar(Facultad.class, id);
	}
	
	public List<Facultad> listar() {
		return dao.ejecutarNamedQuery(Facultad.LISTAR);
	}
}
