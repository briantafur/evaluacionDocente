package co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades;

import java.io.Serializable;
import java.time.Year;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Brian David Tafur Londoño<br/>
 *         email: tafur2401@gmail.com <br/>
 *         Fecha: 11 de ago. de 2016<br/>
 */

@Entity
@Table(name="T_EVALUACION")
public class Evaluacion implements Serializable{

	/* Atributos */
	
	@Id
	@Column(name="ID_EVALUACION", nullable=false)
	private int id;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;
	
	@Column(name="ESTADO", nullable=false, length=45)
	private String estado;
	
	@Column(name="ANHO", nullable=false)
	private Year anho;
	
	@Column(name="PERIODO" , nullable= false)
	private int periodo;

	/* Constructor */
	
	public Evaluacion(int id, Date fechaCreacion, String estado, Year anho, int periodo) {
		super();
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.anho = anho;
		this.periodo = periodo;
	}
	
	public Evaluacion(){
		
	}
	
	/* Getters and Setters */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Year getAnho() {
		return anho;
	}

	public void setAnho(Year anho) {
		this.anho = anho;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	
	
}
