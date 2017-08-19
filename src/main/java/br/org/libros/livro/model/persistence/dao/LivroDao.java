package br.org.libros.livro.model.persistence.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.comum.model.persistence.dao.AbstractDao;
import br.org.libros.comum.model.persistence.entity.Livro;

/**
 * 
 * @see br.org.libros.comum.model.persistence.dao.AbstractDao
 */
@Named
@RequestScoped
public class LivroDao extends AbstractDao<Livro, Integer> {
	private static final long serialVersionUID = 1L;

}