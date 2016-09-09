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

import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones.PreguntaEJB;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Pregunta;



@RunWith(Arquillian.class)
public class PruebaEJBPregunta {

	@EJB
	private PreguntaEJB preguntaEJB;

	@Deployment
	public static EnterpriseArchive desplegar() {

		EnterpriseArchive ear = ArquillianUtil
				.createDeployment("../evaluaciondocente-ear/target/evaluaciondocente-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaEJBPregunta.class));
		return ear;

	}

	@Test
	public void testCrearPregunta() {
		System.out.println("se entra al metodo");
		Pregunta p = new Pregunta();

		p.setTexto("12345678");
		p.setValor(2);
		preguntaEJB.crear(p);

		Pregunta pre = preguntaEJB.buscar(p.getId());
		Assert.assertEquals("12345678", pre.getTexto());
	}

	@AfterClass
	public static void finPrueba() {
		System.out.println("saliendo");
		TestDataUtil.ejecutarSQL("sqltest/prueba-del.sql");

	}

}
