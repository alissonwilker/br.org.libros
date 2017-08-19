package br.org.libros.comum.view.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.org.libros.comum.utils.VerificadorIsbn;
import br.org.libros.comum.view.utils.FacesMessageUtils;

@FacesValidator(value = "isbnValidator")
public class IsbnValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object isbn) throws ValidatorException {
		if (isbn == null) {
			return;
		}
		
		if (!VerificadorIsbn.isValido((String)isbn)) {
			throw new ValidatorException(FacesMessageUtils.getInfoFacesMessage("livros.isbnValidator"));
		}
	}

}