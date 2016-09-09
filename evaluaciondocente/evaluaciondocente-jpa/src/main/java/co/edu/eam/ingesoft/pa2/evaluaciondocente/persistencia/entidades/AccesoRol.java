package co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
@Entity
@NamedQuery(name=AccesoRol.LISTAR_ACCESOS,query="SELECT accrol.acceso FROM AccesoRol accrol WHERE accrol.rol=?1")
@IdClass(value = AccesoRolPK.class)
public class AccesoRol implements Serializable{
	
	public static final String LISTAR_ACCESOS="accesorol.listaraccesos";
	
	@Id
	@ManyToOne
	private Rol rol;
	
	@Id
	@ManyToOne
	private Acceso acceso;
	
	public AccesoRol() {
		// TODO Auto-generated constructor stub
	}

	public AccesoRol(Rol rol, Acceso acceso) {
		super();
		this.rol = rol;
		this.acceso = acceso;
	}

	/**
	 * @return El atributo rol
	 */
	public Rol getRol() {
		return rol;
	}

	/**
	 * Establece el valor del atributo rol
	 * @param rol: EL rol a establecer
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}

	/**
	 * @return El atributo acceso
	 */
	public Acceso getAcceso() {
		return acceso;
	}

	/**
	 * Establece el valor del atributo acceso
	 * @param acceso: EL acceso a establecer
	 */
	public void setAcceso(Acceso acceso) {
		this.acceso = acceso;
	}
	
	
	
}
