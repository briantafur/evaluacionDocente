package co.edu.eam.ingesoft.pa2.evaluaciondocente.persistencia.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * 
 * @author Brian David Tafur Londoño<br/>
 *         email: tafur2401@gmail.com <br/>
 *         Fecha: 11 de ago. de 2016<br/>
 */
@Entity
@Table(name = "T_SUPERADMIN")
public class SuperAdmin extends Usuario {

	public SuperAdmin() {

	}

	public SuperAdmin(int id, String nombre, String apellido, String user, String pass) {
		super(id, nombre, apellido, user, pass);
	}

}
