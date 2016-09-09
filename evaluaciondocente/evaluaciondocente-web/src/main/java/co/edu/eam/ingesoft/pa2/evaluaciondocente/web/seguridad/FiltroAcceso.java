package co.edu.eam.ingesoft.pa2.evaluaciondocente.web.seguridad;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades.Acceso;

@WebFilter(urlPatterns="/paginas/*")
public class FiltroAcceso implements Filter {

	@Inject
	private SessionBean sesion;
	
	Logger logger = Logger.getLogger(FiltroAcceso.class);
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpreq = (HttpServletRequest) request;
		HttpServletResponse httpresp = (HttpServletResponse) resp;
		
		String urlcompleta = httpreq.getRequestURI().toString();
		String contextpath = httpreq.getContextPath();
		
		logger.info("url=" + urlcompleta + ",path=" + contextpath);
		String url = urlcompleta.substring(contextpath.length());
		
		logger.info("URL a filtrar=" + url);
		
		//Si el usuario esta en sesion y no es la pagina de inicio que todos
		//tienen
		if (sesion.isLogged()) {
			//Busca si tiene acceso a la pagina
			boolean exito = false;
			if (url.equals("/paginas/index.jsf")) {
				exito = true;
			} else {
				//Recorre los accesos autorizados
				List<Acceso> accesos = sesion.getAccesos();
				
				for (Acceso acceso: accesos) {
					//Si esta en la lista de accesos autorizados...
					if (acceso.getUrl().equals(url)) {
						exito = true;
					}
				}
			}
			//No esta en la lista, lo redirige a la de inicio
			if (!exito) {
				httpresp.sendRedirect(httpreq.getContextPath() + "/paginas/index.jsf");
			} else {
				//Continua la peticion
				chain.doFilter(request, resp);
			}
		} else {
			//No esta en sesion, lo dirige al principio
			httpresp.sendRedirect(httpreq.getContextPath()+"/login.jsf");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}