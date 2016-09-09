package co.edu.eam.ingesoft.pa2.evaluaciondocente.web.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones.FacultadEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones.ProgramaEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Facultad;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Programa;

@Named("controladorprograma")
@ViewScoped
public class ControladorPrograma implements Serializable {

	private Facultad facultad;
	private String nombre;
	private String idprograma;
	private List<Facultad> facultades;

	@EJB
	private ProgramaEJB programaEJB;

	@EJB
	private FacultadEJB facultadEJB;

	@PostConstruct
	public void inicializar() {
		facultades = facultadEJB.listar();
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Facultad> getFacultades() {
		return facultades;
	}

	public void setFacultades(List<Facultad> facultades) {
		this.facultades = facultades;
	}

	public String getIdprograma() {
		return idprograma;
	}

	public void setIdprograma(String idprograma) {
		this.idprograma = idprograma;
	}

	public void crearPrograma() {

		Programa programa = new Programa(idprograma, nombre, facultad);
		programaEJB.crear(programa);
		Messages.addGlobalInfo("Programa registrado con exito");
	}
}