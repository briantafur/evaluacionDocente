package co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades;

import javax.persistence.Entity;
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
@Table(name = "T_DECANO")
public class Decano extends Usuario {

	/* Atributos */

	@ManyToOne
	@JoinColumn(name = "ID_FACULTAD", nullable = false)
	private Facultad facultad;

	/* Constructor */

	public Decano(int id, String nombre, String apellido, String user, String pass, Facultad facultad) {
		super(id, nombre, apellido, user, pass);
		this.facultad = facultad;
	}

	public Decano() {

	}

	/* Getters y Setters */
	
	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

}
