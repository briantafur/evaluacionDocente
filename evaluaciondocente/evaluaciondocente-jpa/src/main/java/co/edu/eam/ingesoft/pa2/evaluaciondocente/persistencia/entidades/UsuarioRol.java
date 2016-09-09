package co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="T_USUARIOROL")
@IdClass(value= UsuarioRolPK.class)
@NamedQuery(name=UsuarioRol.LISTAR,query="SELECT usrol.rol FROM UsuarioRol usrol WHERE usrol.usuario=?1")
public class UsuarioRol implements Serializable {
	
	public static final String LISTAR = "usuariorol.listarroles";

	@Id
	@ManyToOne
	private Usuario usuario;
	
	@Id
	@ManyToOne
	private Rol rol;

	public UsuarioRol() {
	}
	
	public UsuarioRol(Usuario usuario, Rol rol) {
		super();
		this.usuario = usuario;
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
}
