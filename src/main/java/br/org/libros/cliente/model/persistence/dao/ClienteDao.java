package br.org.libros.cliente.model.persistence.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.comum.model.persistence.dao.AbstractDao;
import br.org.libros.comum.model.persistence.entity.Cliente;

/**
 * 
 * @see br.org.libros.comum.model.persistence.dao.AbstractDao
 */
@Named
@RequestScoped
public class ClienteDao extends AbstractDao<Cliente, Integer> {
	private static final long serialVersionUID = 1L;

}
