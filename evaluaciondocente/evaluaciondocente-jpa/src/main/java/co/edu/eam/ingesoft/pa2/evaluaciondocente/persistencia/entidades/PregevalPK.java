package co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades;

import java.io.Serializable;

/**
 * 
 * @author Brian David Tafur Londoño<br/>
 *         email: tafur2401@gmail.com <br/>
 *         Fecha: 11 de ago. de 2016<br/>
 */
public class PregevalPK implements Serializable{

	/* Atributos */
	
	private int pregunta;
	
	private int evaluacion;
	
	/* Conatructor */
	
	public PregevalPK(){
		
	}

	public PregevalPK(int pregunta, int evaluacion) {
		super();
		this.pregunta = pregunta;
		this.evaluacion = evaluacion;
	}

	/* Getters y Setters */
	
	public int getPregunta() {
		return pregunta;
	}

	public void setPregunta(int pregunta) {
		this.pregunta = pregunta;
	}

	public int getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(int evaluacion) {
		this.evaluacion = evaluacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + evaluacion;
		result = prime * result + pregunta;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PregevalPK other = (PregevalPK) obj;
		if (evaluacion != other.evaluacion)
			return false;
		if (pregunta != other.pregunta)
			return false;
		return true;
	}
	
	
	
	
}
