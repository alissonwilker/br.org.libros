package br.org.libros.livro.model.persistence.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.livro.model.persistence.entity.Livro;

/**
 * 
 * @see br.org.libros.livro.model.persistence.dao.LivroAbstractDao
 */
@Named
@RequestScoped
public class LivroDao extends LivroAbstractDao<Livro, Integer> {
	private static final long serialVersionUID = 1L;

}