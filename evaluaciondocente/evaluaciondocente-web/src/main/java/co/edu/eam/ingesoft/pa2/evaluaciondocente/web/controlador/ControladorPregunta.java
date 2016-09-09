package co.edu.eam.ingesoft.pa2.evaluaciondocente.web.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones.PreguntaEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Pregunta;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.web.interceptors.ExceptionLogger;
/**
 * 
 * @author Brian David Tafur Londoño<br/>
 *         email: tafur2401@gmail.com <br/>
 *         Fecha: 11 de ago. de 2016<br/>
 */
@Named("controladorPreguntas")
@ViewScoped
@ExceptionLogger
public class ControladorPregunta implements Serializable {

	private String pregunta;
	private int porcentaje;
	private List<Integer> pesosCombo = new ArrayList<>();
	private Integer pesoActual;
	private List<Pregunta> preguntas = new ArrayList<>();
	private int idPregunta;
	private String preguntaE;
	private int porcentageE;

	@EJB
	private PreguntaEJB preguntaEJB;

	@PostConstruct
	public void iniciar() {
		refrescarPeso();
		cargarCombo();
	}

	/**
	 * Método para llenar el combo con valores disponibles hasta un máximo de
	 * 40%
	 * 
	 * @author Brian David Tafur Londoño<br/>
	 *         email: tafur2401@gmail.com <br/>
	 *         Fecha: 11 de ago. de 2016<br/>
	 */
	public void cargarCombo() {
		for (int i = 1; i <= 8; i++) {
			if (pesoActual + (i * 5) <= 100) {
				pesosCombo.add(i * 5);
			}
		}
	}

	/**
	 * Método para actualizar el peso total de las preguntas
	 * 
	 * @author Brian David Tafur Londoño<br/>
	 *         email: tafur2401@gmail.com <br/>
	 *         Fecha: 11 de ago. de 2016<br/>
	 */
	public void refrescarPeso() {
		setPesoActual(preguntaEJB.pesoActual());
	}

	/**
	 * Método para registrar una nueva pregunta
	 * 
	 * @author Brian David Tafur Londoño<br/>
	 *         email: tafur2401@gmail.com <br/>
	 *         Fecha: 11 de ago. de 2016<br/>
	 */
	public void registrar() {
		Pregunta pre = new Pregunta(pregunta, porcentaje);
		preguntaEJB.crear(pre);
		refrescarPeso();

		Messages.addGlobalInfo("Pregunta registrada con exito");
		limpiarCampos();
		cargarCombo();
	}

	public void editar() {
		Pregunta pre = preguntaEJB.buscar(idPregunta);
		pre.setTexto(preguntaE);
		pre.setValor(porcentageE);
		preguntaEJB.editar(pre);

	}

	/**
	 * Método para limpiar los campos en la ventana registro de preguntas
	 * 
	 * @author Brian David Tafur Londoño<br/>
	 *         email: tafur2401@gmail.com <br/>
	 *         Fecha: 11 de ago. de 2016<br/>
	 */
	public void limpiarCampos() {
		setPregunta(null);
		setPorcentaje(0);
		pesosCombo = new ArrayList<>();
	}

	public void cargarLista() {
		setPreguntas(preguntaEJB.listar());
	}

	public void setPesoActual(Integer pesoActual) {
		this.pesoActual = pesoActual;
	}

	public String getPregunta() {
		return pregunta;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public List<Integer> getPesosCombo() {
		return pesosCombo;
	}

	public Integer getPesoActual() {
		return pesoActual;
	}

	public PreguntaEJB getPreguntaEJB() {
		return preguntaEJB;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public void setPesosCombo(List<Integer> pesosCombo) {
		this.pesosCombo = pesosCombo;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getPreguntaE() {
		return preguntaE;
	}

	public void setPreguntaE(String preguntaE) {
		this.preguntaE = preguntaE;
	}

	public int getPorcentageE() {
		return porcentageE;
	}

	public void setPorcentageE(int porcentageE) {
		this.porcentageE = porcentageE;
	}

}