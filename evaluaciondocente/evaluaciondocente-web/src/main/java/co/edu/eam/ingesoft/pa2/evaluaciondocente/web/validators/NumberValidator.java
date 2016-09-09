package co.edu.eam.ingesoft.pa2.evaluaciondocente.web.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
/**
 * 
 * @author Brian David Tafur Londoño<br/>
 *         email: tafur2401@gmail.com <br/>
 *         Fecha: 11 de ago. de 2016<br/>
 */
@Named
@FacesValidator(value = "numeros")
public class NumberValidator implements Validator{

	public void validate(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {

		if (value instanceof String) {
			String valor = (String) value;
			if (!(valor.matches("[0-9]*"))) {
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "El campo solo permite números", null));
			}
		}else{
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Indique solo números", null));
		}

	}
	
}
