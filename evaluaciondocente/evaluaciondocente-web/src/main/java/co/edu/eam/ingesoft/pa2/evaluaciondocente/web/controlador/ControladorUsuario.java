package co.edu.eam.ingesoft.pa2.evaluaciondocente.web.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones.CoordinadorEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones.DecanoEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones.FacultadEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones.ProgramaEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones.UsuarioEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Coordinador;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Decano;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Facultad;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Programa;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.web.interceptors.ExceptionLogger;
/**
 * Controlador para la ventana de registro de usuario
 * @author Brian David Tafur Londoño<br/>
 *         email: tafur2401@gmail.com <br/>
 *         Fecha: 11 de ago. de 2016<br/>
 */
@Named("controladorCrearUsuario")
@ViewScoped
@ExceptionLogger
public class ControladorUsuario implements Serializable {

	private String nombre;
	private String apellido;
	private String cedula;
	private String nickname;
	private String password;
	/**
	 * Variable que representa la seleccion del combo del tipo de Usuario
	 */
	private int tipoUsuario;
	/**
	 * Variable que carga el segundo combo con los programas
	 */
	private List<Programa> listaProgramas;
	/**
	 * Variable que carga el segundo combo con las facultades
	 */
	private List<Facultad> listaFacultad;
	private Programa programa;
	private Facultad facultad;
	@EJB
	private DecanoEJB decanoEJB;
	@EJB
	private CoordinadorEJB coordinadorEJB;
	@EJB
	private ProgramaEJB programaEJB;
	@EJB
	private FacultadEJB facultadEJB;
	@EJB
	private UsuarioEJB usuarioEJB;

	@PostConstruct
	public void inicializar() {
		listaFacultad = new ArrayList<>();
		listaProgramas = new ArrayList<>();
	}

	/**
	 * Método para cargar un combo según sea necesario, ya sea de facultades o
	 * de programas
	 * 
	 * @author Brian David Tafur Londoño<br/>
	 *         email: tafur2401@gmail.com <br/>
	 *         Fecha: 11 de ago. de 2016<br/>
	 */
	public void cambioEstado() {
		if (tipoUsuario == 1) {
			setListaProgramas(programaEJB.listar());
		}
		if (tipoUsuario == 2) {
			setListaFacultad(facultadEJB.listar());
		}
	}

	/**
	 * Método para el registro de un nuevo usuario
	 * 
	 * @author Brian David Tafur Londoño<br/>
	 *         email: tafur2401@gmail.com <br/>
	 *         Fecha: 11 de ago. de 2016<br/>
	 */
	public void registrar() {
		if (tipoUsuario == 1) {
			Coordinador coordinador = new Coordinador(Integer.parseInt(cedula), nombre, apellido, nickname, password, programa);
			usuarioEJB.crear(coordinador);
			Messages.addGlobalInfo("Coordinador registrado con exito");
		}
		if (tipoUsuario == 2) {
			Decano decano = new Decano(Integer.parseInt(cedula), nombre, apellido, nickname, password, facultad);
			usuarioEJB.crear(decano);
			Messages.addGlobalInfo("Decano registrado con exito");
		}
	}

	/**
	 * Método para limpiar los campos en la ventana de RegistroPreguntas
	 * 
	 * @author Brian David Tafur Londoño<br/>
	 *         email: tafur2401@gmail.com <br/>
	 *         Fecha: 11 de ago. de 2016<br/>
	 */
	public void limpiarCampos() {
		nombre = null;
		apellido = null;
		cedula = null;
		nickname = null;
		password = null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<Programa> getListaProgramas() {
		return listaProgramas;
	}

	public void setListaProgramas(List<Programa> listaProgramas) {
		this.listaProgramas = listaProgramas;
	}

	public List<Facultad> getListaFacultad() {
		return listaFacultad;
	}

	public void setListaFacultad(List<Facultad> listaFacultad) {
		this.listaFacultad = listaFacultad;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public DecanoEJB getDecanoEJB() {
		return decanoEJB;
	}

	public void setDecanoEJB(DecanoEJB decanoEJB) {
		this.decanoEJB = decanoEJB;
	}

	public CoordinadorEJB getCoordinadorEJB() {
		return coordinadorEJB;
	}

	public void setCoordinadorEJB(CoordinadorEJB coordinadorEJB) {
		this.coordinadorEJB = coordinadorEJB;
	}

	public ProgramaEJB getProgramaEJB() {
		return programaEJB;
	}

	public void setProgramaEJB(ProgramaEJB programaEJB) {
		this.programaEJB = programaEJB;
	}

	public FacultadEJB getFacultadEJB() {
		return facultadEJB;
	}

	public void setFacultadEJB(FacultadEJB facultadEJB) {
		this.facultadEJB = facultadEJB;
	}

	public UsuarioEJB getUsuarioEJB() {
		return usuarioEJB;
	}

	public void setUsuarioEJB(UsuarioEJB usuarioEJB) {
		this.usuarioEJB = usuarioEJB;
	}
	
	
}
