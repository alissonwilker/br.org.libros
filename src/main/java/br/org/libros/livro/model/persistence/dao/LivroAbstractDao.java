package br.org.libros.livro.model.persistence.dao;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.org.libros.comum.model.persistence.dao.AbstractDao;

/**
 * Classe abstrata que implementa comportamento padrão dos DAO's do módulo Livro.
 * 
 * @see br.org.libros.comum.model.persistence.dao.AbstractDao
 */
public abstract class LivroAbstractDao<E, PK extends Serializable> extends AbstractDao<E, PK> {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "LibrosLivroPersistenceUnit", type = PersistenceContextType.TRANSACTION)
	protected EntityManager entityManager;

	@PostConstruct
	public void init() {
		setEntityManager(entityManager);
	}
}
