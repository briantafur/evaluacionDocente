package co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author Brian David Tafur Londoño<br/>
 *         email: tafur2401@gmail.com <br/>
 *         Fecha: 11 de ago. de 2016<br/>
 */

@Entity
@Table(name = "T_FACULTAD")
@NamedQuery(name = Facultad.LISTAR, query = "SELECT fac FROM Facultad fac")
public class Facultad implements Serializable {

	/* Atributos */
	public static final String LISTAR = "facultad.listar";

	@Id
	@Column(name = "ID_FACULTAD", length = 45, nullable = false)
	private String id;

	@Column(name = "NOMBRE", length = 45, nullable = false)
	private String nombre;

	/* Constructor */

	public Facultad() {

	}

	public Facultad(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	/* Getters y Setters */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Facultad)) {
			return false;
		}
		Facultad other = (Facultad) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

}
