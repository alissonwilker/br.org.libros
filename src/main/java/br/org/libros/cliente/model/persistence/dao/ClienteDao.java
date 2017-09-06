package br.org.libros.cliente.model.persistence.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.biblioteca.model.persistence.dao.LibrosAbstractDao;
import br.org.libros.cliente.model.persistence.entity.Cliente;

/**
 * 
 * @see br.org.libros.biblioteca.model.persistence.dao.LibrosAbstractDao
 */
@Named
@RequestScoped
public class ClienteDao extends LibrosAbstractDao<Cliente, Integer> {
	private static final long serialVersionUID = 1L;

}
