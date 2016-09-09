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
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones.FacultadEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones.PreguntaEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Facultad;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Pregunta;



@RunWith(Arquillian.class)
public class PruebaEJBFacultad {

	@EJB
	private FacultadEJB facultadEJB;

	@Deployment
	public static EnterpriseArchive desplegar() {

		EnterpriseArchive ear = ArquillianUtil
				.createDeployment("../evaluaciondocente-ear/target/evaluaciondocente-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaEJBFacultad.class));
		return ear;

	}

	@Test
	public void testCrearPregunta() {
		System.out.println("se entra al metodo");
		Facultad fac = facultadEJB.buscar("admon");

		
		Assert.assertEquals("Administración", fac.getNombre());
	}

	@AfterClass
	public static void finPrueba() {
		System.out.println("saliendo");
		TestDataUtil.ejecutarSQL("sqltest/prueba-del.sql");

	}

}
