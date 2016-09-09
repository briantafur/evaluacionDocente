package co.edu.eam.ingesoft.pa2.evaluaciondocente.web.seguridad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones.AccesoEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones.RolEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones.UsuarioEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Acceso;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Rol;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Usuario;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.web.seguridad.MD5Util;

@Named("sessionbean")
@SessionScoped
public class SessionBean implements Serializable {

	private Logger logger = Logger.getLogger(SessionBean.class);
	private String nickname;
	private String contra;
	private List<Acceso> accesos;
	private List<Rol> roles;
	private Usuario usuario;

	@EJB
	private RolEJB rolEJB;

	@EJB
	private AccesoEJB accesoEJB;

	@EJB
	private UsuarioEJB usuarioEJB;

	public SessionBean() {
		// TODO Auto-generated constructor stub
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public List<Acceso> getAccesos() {
		return accesos;
	}

	public void setAccesos(List<Acceso> accesos) {
		this.accesos = accesos;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String iniciarSesion() {
		usuario = usuarioEJB.buscarUsuarioNickname(nickname);
		contra = MD5Util.code(contra);
		if (usuario != null && usuario.getPass().equals(contra)) {
			roles = rolEJB.listar(usuario);
			List<Acceso> accesosAux = new ArrayList<>();
			for (int i = 0; i < roles.size(); i++) {
				accesosAux = accesoEJB.listarAccesos(roles.get(i));
				// accesos.add(e);
			}
			accesos = accesosAux;
			Messages.addGlobalInfo("Inicio de sesion exitoso!!!");
			return "/paginas/index.jsf?faces-redirect=true";
		} else {
			usuario = null;
			roles = null;
			accesos = null;
			Messages.addGlobalInfo("Usuario o password incorrectos");
			return null;
		}
	}

	/**
	 * Método que valida si hay sesion
	 * 
	 * @return true si hay sesion, de lo contrario false
	 */
	public boolean isLogged() {
		return usuario != null;
	}

	public String logOut() {
		Faces.getSession().invalidate();
		usuario = null;
		return "/login.jsf=faces-redirect=true";
	}

}
