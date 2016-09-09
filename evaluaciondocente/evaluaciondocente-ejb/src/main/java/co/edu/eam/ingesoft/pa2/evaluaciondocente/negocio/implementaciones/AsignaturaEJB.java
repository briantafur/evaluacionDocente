package co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Asignatura;


@Stateless
@LocalBean
public class AsignaturaEJB extends EJBGenerico<Asignatura>{

	public Asignatura buscar(int codigo){
		return null;
	}
	
	public void crear(Asignatura asignatura){
		
	}
	
	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return  Asignatura.class;
	}

}
