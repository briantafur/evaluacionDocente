package co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades;

import java.io.Serializable;

public class UsuarioRolPK implements Serializable{

	private int usuario;
	
	private int rol;
	
	public UsuarioRolPK() {
		// TODO Auto-generated constructor stub
	}

	public UsuarioRolPK(int usuario, int rol) {
		super();
		this.usuario = usuario;
		this.rol = rol;
	}

	/**
	 * @return El atributo usuario
	 */
	public int getUsuario() {
		return usuario;
	}

	/**
	 * Establece el valor del atributo usuario
	 * @param usuario: EL usuario a establecer
	 */
	public void setUsuario(int usuario) {
		this.usuario = usuario;
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
	
	
	
}
