package co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades;

import java.io.Serializable;

public class AccesoRolPK implements Serializable{

	private int rol;
	private int acceso;
	
	public AccesoRolPK() {
		// TODO Auto-generated constructor stub
	}
	
	

	public AccesoRolPK(int rol, int acceso) {
		super();
		this.rol = rol;
		this.acceso = acceso;
	}



	/**
	 * @return El atributo rol
	 */
	public int getRol() {
		return rol;
	}

	/**
	 * Establece el valor del atributo rol
	 * @param rol: EL rol a establecer
	 */
	public void setRol(int rol) {
		this.rol = rol;
	}

	/**
	 * @return El atributo acceso
	 */
	public int getAcceso() {
		return acceso;
	}

	/**
	 * Establece el valor del atributo acceso
	 * @param acceso: EL acceso a establecer
	 */
	public void setAcceso(int acceso) {
		this.acceso = acceso;
	}
	
	
	
}
