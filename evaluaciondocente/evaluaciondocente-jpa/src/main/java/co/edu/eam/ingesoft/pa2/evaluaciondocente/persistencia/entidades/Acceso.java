package co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_ACCESO")
public class Acceso implements Serializable{

	@Id
	private int id;
	private String nombre;
	private String url;
	
	/**
	 * Constructor vacío
	 */
	public Acceso() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return El atributo id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el valor del atributo id
	 * @param id: EL id a establecer
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return El atributo nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el valor del atributo nombre
	 * @param nombre: EL nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return El atributo url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Establece el valor del atributo url
	 * @param url: EL url a establecer
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
