package br.org.libros.cliente.model.persistence.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.biblioteca.model.persistence.dao.BibliotecaAbstractDao;
import br.org.libros.cliente.model.persistence.entity.Cliente;

/**
 * 
 * @see br.org.libros.biblioteca.model.persistence.dao.BibliotecaAbstractDao
 */
@Named
@RequestScoped
public class ClienteDao extends BibliotecaAbstractDao<Cliente, Integer> {
	private static final long serialVersionUID = 1L;

}
