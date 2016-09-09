package co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.implementaciones;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.dao.DAOGenerico;


//@Stateless
//@Remote(InterfaceEJBGenerica<T>.class)
public abstract class EJBGenerico<T> {
	
	@PersistenceContext
	private EntityManager em;
	
	protected DAOGenerico dao;
	
	private Class<T> clase;
	
	@PostConstruct
	public void inicializar(){
		dao=new DAOGenerico(em, getClase());
	}
	
	public void editar(T entidad){
		dao.editar(entidad);
	}
	
	/**
	 * 
	 * @param pk
	 * @return
	 */
	public T buscar(Object pk){
		return dao.buscar(clase, pk);
	}
	
	public void eliminar(T entidad){
		dao.borrar(entidad);
	}
	
	public void crear (T entidad){
		dao.crear(entidad);
	}
	
	
	public abstract Class getClase();
	
	

}
