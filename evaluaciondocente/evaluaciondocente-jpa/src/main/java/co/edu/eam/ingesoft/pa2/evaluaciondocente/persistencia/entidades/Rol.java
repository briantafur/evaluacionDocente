package co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Brian David Tafur Londoño<br/>
 *         email: tafur2401@gmail.com <br/>
 *         Fecha: 20 de ago. de 2016<br/>
 */
@Entity
@Table(name = "T_ROL")
public class Rol implements Serializable{

	@Id
	private int id;
	private String descripcion;

	/**
	 * Constructor vacío
	 */
	public Rol() {
		
	}

	/**
	 * @return El atributo id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el valor del atributo id
	 * 
	 * @param id:
	 *            EL id a establecer
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return El atributo descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece el valor del atributo descripcion
	 * 
	 * @param descripcion:
	 *            EL descripcion a establecer
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
