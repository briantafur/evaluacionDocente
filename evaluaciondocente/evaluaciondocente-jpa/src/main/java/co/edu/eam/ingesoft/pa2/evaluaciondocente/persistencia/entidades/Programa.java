package co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author Brian David Tafur Londoño<br/>
 *         email: tafur2401@gmail.com <br/>
 *         Fecha: 11 de ago. de 2016<br/>
 */
@Entity
@Table(name="T_PROGRAMA")
@NamedQuery(name=Programa.LISTAR,query="SELECT pro FROM Programa pro")
public class Programa implements Serializable{

	/* Atributos */
	public static final String LISTAR = "programa.listar";
	@Id
	@Column(name="ID_PROGRAMA", length = 45, nullable=false)
	private String id;
	
	@Column(name="NOMBRE", length = 45, nullable=false)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="ID_FACULTAD", nullable=false)
	private Facultad facultad;

	/* Constructor */

	public Programa(String id, String nombre, Facultad facultad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.facultad = facultad;
	}
	
	public Programa(){
		
	}

	/* Getters And Setters */
	
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

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
