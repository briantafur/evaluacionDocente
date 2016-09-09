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
@Table(name = "T_COORDINADOR")
public class Coordinador extends Usuario {

	/* Atributos */

	@ManyToOne
	@JoinColumn(name = "ID_PROGRAMA", nullable = false)
	private Programa programa;

	/* Constructor */

	public Coordinador() {

	}

	public Coordinador(int id, String nombre, String apellido, String user, String pass, Programa programa) {
		super(id, nombre, apellido, user, pass);
		this.programa = programa;
	}
	
	/* Getters y Setters */

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}	

}
