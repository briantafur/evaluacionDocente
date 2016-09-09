package test.clase;
import javax.ejb.EJB;

import org.caferrer.testdata.junit.ArquillianUtil;
import org.caferrer.testdata.junit.TestDataUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones.FacultadEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones.ProgramaEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Facultad;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Programa;



@RunWith(Arquillian.class)
public class PruebaEJBPrograma {
	@EJB
	private ProgramaEJB programaEJB;
	@EJB
	private FacultadEJB facultadEJB;
	
	
	@Deployment
	public static EnterpriseArchive desplegar(){
		 
		EnterpriseArchive ear= ArquillianUtil.createDeployment("../evaluaciondocente-ear/target/evaluaciondocente-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaEJBPrograma.class));
		return ear;
		
	}
	
	@Test
	public void testCrearPrograma(){
		Programa p = new Programa();
		Facultad fac = new Facultad();
		fac.setId("admon");
	    p.setId("adm");
	    p.setNombre("Administración");
	    p.setFacultad(fac);
		programaEJB.crear(p);
		
		Programa pre = programaEJB.buscar(p.getId());
		Assert.assertEquals("Administración", pre.getNombre());
	}
	
	@AfterClass
	public static void finalizarPrueba(){
		TestDataUtil.ejecutarSQL("sqltest/Prueba-del.sql");		
	}
}
