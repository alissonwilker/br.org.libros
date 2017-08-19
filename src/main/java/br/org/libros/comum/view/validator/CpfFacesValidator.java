package br.org.libros.comum.view.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.org.libros.comum.utils.VerificadorCpf;
import br.org.libros.comum.view.utils.FacesMessageUtils;

/**
 * Validador de CPF utilizado pelo JSF.
 *
 * @see javax.faces.validator.Validator
 */
@FacesValidator(value = "cpfValidator")
public class CpfFacesValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object cpf) throws ValidatorException {
		if (cpf == null) {
			return;
		}

		if (!VerificadorCpf.isValido((String) cpf)) {
			throw new ValidatorException(FacesMessageUtils.getInfoFacesMessage("clientes.cpfValidator"));
		}
	}
}