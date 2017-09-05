package br.org.libros.biblioteca.model.business;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.biblioteca.model.persistente.entity.Livro;
import br.org.libros.comum.model.business.AbstractBusiness;

/**
 * 
 * @see br.org.libros.comum.model.business.AbstractBusiness
 */
@Named("LivroBibliotecaBusiness")
@RequestScoped
public class LivroBusiness extends AbstractBusiness<Livro, Integer> {

	private static final long serialVersionUID = 1L;

}
