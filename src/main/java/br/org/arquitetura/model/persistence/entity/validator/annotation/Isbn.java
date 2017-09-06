package br.org.arquitetura.model.persistence.entity.validator.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.org.arquitetura.model.persistence.entity.validator.IsbnBeanValidator;

/**
 * Anotação associada a um validador de ISBN para Beans.
 *
 */
@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = IsbnBeanValidator.class)
@Documented
public @interface Isbn {

	String message() default "{isbn.invalido}"; 

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}