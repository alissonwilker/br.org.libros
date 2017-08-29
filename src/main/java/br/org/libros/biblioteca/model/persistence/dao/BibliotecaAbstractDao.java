package br.org.libros.biblioteca.model.persistence.dao;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.org.libros.comum.model.persistence.dao.AbstractDao;

/**
 * 
 * @see br.org.libros.comum.model.persistence.dao.AbstractDao
 */
public abstract class BibliotecaAbstractDao<E, PK extends Serializable> extends AbstractDao<E, PK> {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "LibrosBibliotecaPersistenceUnit", type = PersistenceContextType.TRANSACTION)
	protected EntityManager entityManager;

	@PostConstruct
	public void init() {
		setEntityManager(entityManager);
	}
}
