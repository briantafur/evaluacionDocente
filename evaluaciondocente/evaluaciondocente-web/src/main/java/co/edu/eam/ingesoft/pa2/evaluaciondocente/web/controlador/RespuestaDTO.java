package co.edu.eam.ingesoft.pa2.evaluaciondocente.web.controlador;

public class RespuestaDTO {

	private Object obj;
	private String mensaje;
	private String codigo;
	
	public RespuestaDTO() {
		
	}

	public RespuestaDTO(Object obj) {
		super();
		this.obj = obj;
		mensaje = "Se ejecutó correctamente";
		codigo = "100";
	}

	public RespuestaDTO(Object obj, String mensaje, String codigo) {
		super();
		this.obj = obj;
		this.mensaje = mensaje;
		this.codigo = codigo;
	}

	/**
	 * @return El atributo obj
	 */
	public Object getObj() {
		return obj;
	}

	/**
	 * Establece el valor del atributo obj
	 * @param obj: EL obj a establecer
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}

	/**
	 * @return El atributo mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Establece el valor del atributo mensaje
	 * @param mensaje: EL mensaje a establecer
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return El atributo codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Establece el valor del atributo codigo
	 * @param codigo: EL codigo a establecer
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
}
