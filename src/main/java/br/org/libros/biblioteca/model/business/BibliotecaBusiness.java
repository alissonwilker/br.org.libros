package br.org.libros.biblioteca.model.business;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.comum.model.business.AbstractBusiness;
import br.org.libros.comum.model.persistence.entity.Biblioteca;

@Named
@RequestScoped
public class BibliotecaBusiness extends AbstractBusiness<Biblioteca, Integer> {

	private static final long serialVersionUID = 1L;

}
