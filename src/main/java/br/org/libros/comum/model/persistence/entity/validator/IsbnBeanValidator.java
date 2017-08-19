package br.org.libros.comum.model.persistence.entity.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.org.libros.comum.model.persistence.entity.validator.annotation.Isbn;
import br.org.libros.comum.utils.VerificadorIsbn;

public class IsbnBeanValidator implements ConstraintValidator<Isbn, String> {

	@Override
	public boolean isValid(String isbn, ConstraintValidatorContext constraintContext) {
		return VerificadorIsbn.isValido(isbn);
	}

	@Override
	public void initialize(Isbn constraintAnnotation) {
	}
}
