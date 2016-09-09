package co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "T_PREGUNTA")
@NamedQuery(name=Pregunta.LISTAR,query="SELECT pre FROM Pregunta pre")
public class Pregunta implements Serializable {

	/* Atributos */
	public static final String LISTAR = "pregunta.listar";
	
	@Id
	@Column(name="ID_PREGUNTA", nullable = false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="TEXTO", nullable = false, length = 45)
	private String texto;
	
	@Column(name="VALOR", nullable = false)
	private int valor;

	/* Constructor */
	
	public Pregunta(String texto, int valor) {
		super();
		this.texto = texto;
		this.valor = valor;
	}
	
	public Pregunta(){
		
	}

	/* Getters y Setters */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
}
