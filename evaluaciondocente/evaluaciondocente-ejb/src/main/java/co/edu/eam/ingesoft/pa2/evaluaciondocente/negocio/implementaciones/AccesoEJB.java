package co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Acceso;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.AccesoRol;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Rol;

@Stateless
@LocalBean
public class AccesoEJB extends EJBGenerico<Acceso> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Acceso> listarAccesos(Rol rol) {
		return dao.ejecutarNamedQuery(AccesoRol.LISTAR_ACCESOS, rol);
	}

}
