package co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.interfaces.IPreguntaEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Facultad;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Pregunta;
/**
 * 
 * @author Brian David Tafur Londoño<br/>
 *         email: tafur2401@gmail.com <br/>
 *         Fecha: 11 de ago. de 2016<br/>
 */
@LocalBean
@Stateless
@Remote(IPreguntaEJB.class)
public class PreguntaEJB extends EJBGenerico<Pregunta> implements IPreguntaEJB {

	@Override
	public Class getClase() {		
		return Pregunta.class;
	}
	
	public void crear(Pregunta pregunta) {
		dao.crear(pregunta);
	}
	
	public Pregunta buscar(Object id) {
		return dao.buscar(Pregunta.class, id);
	}
	/**
	 * Método para calcular el acumulado de peso actual en las preguntas
	 * @author Brian David Tafur Londoño<br/>
	 *         email: tafur2401@gmail.com <br/>
	 *         Fecha: 11 de ago. de 2016<br/>
	 * @return un valor entero con el porcentaje usado hasta el momento
	 */
	public int pesoActual() {
		int pesoActual = 0;
		List<Pregunta> preg = listar();
		for (int i = 0; i < preg.size(); i++) {
			pesoActual += preg.get(i).getValor();
		}
		return pesoActual;
	}
	/**
	 * Método que lista todas las preguntas 
	 * @author Brian David Tafur Londoño<br/>
	 *         email: tafur2401@gmail.com <br/>
	 *         Fecha: 11 de ago. de 2016<br/>
	 * @return una lista con todas las preguntas disponibles
	 */
	public List<Pregunta> listar() {
		return dao.ejecutarNamedQuery(Pregunta.LISTAR);
	}
}
