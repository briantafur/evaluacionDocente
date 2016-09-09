package co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Brian David Tafur Londoño<br/>
 *         email: tafur2401@gmail.com <br/>
 *         Fecha: 11 de ago. de 2016<br/>
 */

@Entity
@Table(name = "T_PREGEVAL")
@IdClass(PregevalPK.class)
public class Pregeval implements Serializable {

	/* Atributos */

	@Id
	@ManyToOne
	@JoinColumn(name = "ID_PREGUNTA", nullable = false, updatable = false, insertable = false)
	private Pregunta pregunta;

	@Id
	@ManyToOne
	@JoinColumn(name = "ID_EVALUACION", nullable = false, updatable = false, insertable = false)
	private Evaluacion evaluacion;

	/* Constructor */

	public Pregeval(Pregunta pregunta, Evaluacion evaluacion) {
		super();
		this.pregunta = pregunta;
		this.evaluacion = evaluacion;
	}

	public Pregeval() {

	}

	/* Getters and Setters */

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

}
