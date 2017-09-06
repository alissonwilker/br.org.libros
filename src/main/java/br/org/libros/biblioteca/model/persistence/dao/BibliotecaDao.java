package br.org.libros.biblioteca.model.persistence.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.biblioteca.model.persistence.entity.Biblioteca;

/**
 * 
 * @see br.org.libros.biblioteca.model.persistence.dao.LibrosAbstractDao
 */
@Named
@RequestScoped
public class BibliotecaDao extends LibrosAbstractDao<Biblioteca, Integer> {
	private static final long serialVersionUID = 1L;

}
