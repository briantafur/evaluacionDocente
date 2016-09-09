package co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.interfaces.IProgramaEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Programa;

@LocalBean
@Stateless
@Remote(IProgramaEJB.class)
public class ProgramaEJB extends EJBGenerico<Programa> implements IProgramaEJB {

	@Override
	public Class getClase() {
		return Programa.class;
	}
	
	public List<Programa> listar() {
		return dao.ejecutarNamedQuery(Programa.LISTAR);
	}
	public Programa buscar(String id){
		return dao.buscar(Programa.class, id);
	}

}
