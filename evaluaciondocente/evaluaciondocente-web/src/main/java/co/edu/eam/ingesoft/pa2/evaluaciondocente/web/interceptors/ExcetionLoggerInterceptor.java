package co.edu.eam.ingesoft.pa2.evaluaciondocente.web.interceptors;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.exepciones.ExcepcionNegocio;
/**
 * 
 * @author Brian David Tafur Londoño<br/>
 *         email: tafur2401@gmail.com <br/>
 *         Fecha: 11 de ago. de 2016<br/>
 */
@Interceptor
@ExceptionLogger
public class ExcetionLoggerInterceptor implements Serializable{

	private static Logger log = Logger.getLogger(ExcetionLoggerInterceptor.class);
	
	@AroundInvoke
	public Object mostrarException(InvocationContext invocationContext){
		log.info("Ingresando al metodo :" + invocationContext.getMethod().getName());
		try{
			return invocationContext.proceed();
		}catch(ExcepcionNegocio exc){
		Messages.addGlobalError(exc.getMessage(), exc);
		log.error(exc.getMessage(),exc);
		}catch(Exception e){
			Faces.getApplication().getNavigationHandler().handleNavigation(Faces.getContext(), null
					,"/error.jsf?faces-redirect=true" , null);
		}finally {
			log.info("Saliendo del metodo :" + invocationContext.getMethod().getName());
		}
		return null;
	}
	
}
