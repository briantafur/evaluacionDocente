package co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Brian David Tafur Londoño<br/>
 *         email: tafur2401@gmail.com <br/>
 *         Fecha: 11 de ago. de 2016<br/>
 */
@Entity
@Table(name = "T_USUARIO")
@NamedQuery(name=Usuario.BUSCAR_NICKNAME, query="SELECT us FROM Usuario us WHERE us.nickname=?1")
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement
public class Usuario implements Serializable {

	public static final String BUSCAR_NICKNAME="usuario.buscarpornickname";
	
	/* Atributos */

	@Id
	@Column(name = "ID_USUARIO", length = 12, nullable = false)
//	@Size(min=6,max=12,message="La longitud debe ser entre 6 y 12 caracteres")
//	@Pattern(regexp="[0-9]*",message="Formato no valido, solo se permiten números")
	protected int id;

	@Column(name = "NOMBRE", length = 45, nullable = false)
	protected String nombre;

	@Column(name = "APELLIDO", length = 45, nullable = false)
	protected String apellido;

	@Column(name = "NICKNAME", length = 45, nullable = false)
	protected String nickname;

	@Column(name = "PASS", length = 45, nullable = false)
	protected String pass;

	/* Constructor */

	public Usuario(int id, String nombre, String apellido, String nickname, String pass) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nickname = nickname;
		this.pass = pass;
	}

	public Usuario() {

	}

	/* Getters y Setters */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
