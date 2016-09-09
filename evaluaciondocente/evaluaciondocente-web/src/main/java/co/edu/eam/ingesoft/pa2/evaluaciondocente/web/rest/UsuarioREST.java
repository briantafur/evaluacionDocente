package co.edu.eam.ingesoft.pa2.evaluaciondocente.web.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones.UsuarioEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Usuario;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.web.controlador.RespuestaDTO;

@Path("/cliente")
public class UsuarioREST {

	@EJB
	private UsuarioEJB usuarioEJB;
	
	public UsuarioREST() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Path("/buscar")
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO buscarUsuario(@QueryParam(value = "ced") int cedula){
		Usuario us = usuarioEJB.buscar(cedula);
		System.out.println(us.getApellido());
		return new RespuestaDTO(us);
	}
	
	@PUT
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RespuestaDTO crearUsuario(Usuario usuario){
		if (usuarioEJB.buscar(usuario.getId()) == null) {
			usuarioEJB.crear(usuario);
			return new RespuestaDTO(true);			
		} else {
			return new RespuestaDTO(false, "el cliente ya existe", "50");
		}
	}
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarUsuario(){
		return null;
	}
	
	
	
}
