package co.edu.eam.ingesoft.pa2.evaluaciondocente.negocio.interfaces;


public interface InterfaceEJBGenerica<T> {

	public void editar(T entidad);
	
	/**
	 * Metodo para buscar un objeto por su primary key
	 * @param pk, la llave primaria del objeto a crear
	 * @return el objeto si se encuentra 
	 */
	public T buscar(Object pk);
	
	/**
	 * Metodo para eliminar un objeto
	 * @author Alejandro Matallana Caballero<br/>
	 *         email: alejito.matallana@gmail.com <br/>
	 *         Fecha: 1/05/2016<br/>
	 * @param entidad, la entidad donde esta el objeto
	 */
	public void eliminar(T entidad);
	
	/**
	 * Metodo para Crear un objeto
	 * @author Alejandro Matallana Caballero<br/>
	 *         email: alejito.matallana@gmail.com <br/>
	 *         Fecha: 1/05/2016<br/>
	 * @param entidad, la entidad donde esta el objeto
	 */
	public void crear(T entidad);
}
