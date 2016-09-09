package test.clase;

import javax.ejb.EJB;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.manejosoap.ConsumidorSoap;

@RunWith(Arquillian.class)
public class PruebaConsumidor {

	@EJB
	private ConsumidorSoap consumidorEJB;
	
	@Test
	public void verificarEstudiante(){
		boolean b = consumidorEJB.buscarEstudiante("1", "1");
		
	}
	
	@Test
	public void verificarGrupo(){
		boolean b = consumidorEJB.listarCursosEstudiante("1", "1");
		
	}
	
}
