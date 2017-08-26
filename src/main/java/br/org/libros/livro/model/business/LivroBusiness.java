package br.org.libros.livro.model.business;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.comum.model.business.AbstractBusiness;
import br.org.libros.livro.model.persistence.entity.Livro;

/**
 * 
 * @see br.org.libros.comum.model.business.AbstractBusiness
 */
@Named
@RequestScoped
public class LivroBusiness extends AbstractBusiness<Livro, Integer> {

	private static final long serialVersionUID = 1L;
}
