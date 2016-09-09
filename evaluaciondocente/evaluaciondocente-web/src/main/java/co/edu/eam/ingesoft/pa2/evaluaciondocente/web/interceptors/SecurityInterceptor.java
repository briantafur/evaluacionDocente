package co.edu.eam.ingesoft.pa2.evaluaciondocente.web.interceptors;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.exepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.evaluaciondocente.web.seguridad.SessionBean;

@Interceptor
@Secured
public class SecurityInterceptor implements Serializable{
	
	private static Logger log = Logger.getLogger(ExcetionLoggerInterceptor.class);
	
	@Inject
	private SessionBean sesion;
	
	@AroundInvoke
	public Object interceptar(InvocationContext ctx)throws Exception{
		
		
		
		//Verificar que el métodoq ue se invoque está anotadp
		if(ctx.getMethod().isAnnotationPresent(Secured.class)){
			if (sesion.isLogged()) {
				Object res = ctx.proceed();
				return res;
			} else {
				 throw new ExcepcionNegocio("No Está autorizado!");
			}
		} else {
			Object res = ctx.proceed();
			return res;
		}
		
	}

}
