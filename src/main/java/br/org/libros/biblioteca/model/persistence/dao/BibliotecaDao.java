package br.org.libros.biblioteca.model.persistence.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.biblioteca.model.persistente.entity.Biblioteca;

/**
 * 
 * @see br.org.libros.biblioteca.model.persistence.dao.BibliotecaAbstractDao
 */
@Named
@RequestScoped
public class BibliotecaDao extends BibliotecaAbstractDao<Biblioteca, Integer> {
	private static final long serialVersionUID = 1L;

}
