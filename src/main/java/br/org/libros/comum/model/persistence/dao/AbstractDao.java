package br.org.libros.comum.model.persistence.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;

import br.org.libros.comum.exception.EntidadeJaExisteExcecao;
import br.org.libros.comum.exception.EntidadeNaoEncontradaExcecao;

/**
 * Classe abstrata que implementa comportamento padrão de um DAO.
 *
 * @param <E> tipo da Entidade.
 * @param <PK> tipo da chave primária da Entidade.
 * 
 * @see br.org.libros.comum.model.persistence.dao.IDao
 */
public abstract class AbstractDao<E, PK extends Serializable> implements IDao<E, PK>, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "MinhaPersistenceUnit", type = PersistenceContextType.TRANSACTION)
	protected EntityManager entityManager;
	private Class<?> domain;

	private Class<?> getDomainClass() {
		if (this.domain == null) {
			this.domain = getGenericTypeArgument(this.getClass(), 0);
		}
		return this.domain;
	}

	@SuppressWarnings("unchecked")
	private static <T> Class<T> getGenericTypeArgument(final Class<?> clazz, final int idx) {
		final Type type = clazz.getGenericSuperclass();
		ParameterizedType paramType;
		try {
			paramType = (ParameterizedType) type;
		} catch (ClassCastException cause) {
			paramType = (ParameterizedType) ((Class<T>) type).getGenericSuperclass();
		}
		return (Class<T>) paramType.getActualTypeArguments()[idx];
	}

	@Override
	public E adicionar(E entidade) throws EntidadeJaExisteExcecao {
		try {
			entityManager.persist(entidade);
			return entidade;
		} catch (PersistenceException eeex) {
			if (eeex.getCause() instanceof ConstraintViolationException) {
				throw new EntidadeJaExisteExcecao(eeex);
			} else {
				throw eeex;
			}
		}
	}

	@Override
	public void remover(PK chavePrimaria) throws EntidadeNaoEncontradaExcecao {
		E entidade = recuperar(chavePrimaria);
		if (entidade != null) {
			entityManager.remove(entidade);
		} else {
			throw new EntidadeNaoEncontradaExcecao();
		}
	}

	@Override
	public void remover(E entidade) throws EntidadeNaoEncontradaExcecao {
		try {
			entidade = entityManager.merge(entidade);
			entityManager.remove(entidade);
		} catch (IllegalArgumentException iaex) {
			throw new EntidadeNaoEncontradaExcecao(iaex);
		}
	}

	@Override
	public E atualizar(E entidade) throws EntidadeNaoEncontradaExcecao {
		try {
			return entityManager.merge(entidade);
		} catch (IllegalArgumentException iaex) {
			throw new EntidadeNaoEncontradaExcecao(iaex);
		}
	}

	@Override
	public E atualizar(PK chavePrimaria, E entidade) throws EntidadeNaoEncontradaExcecao {
		E entidadeRecuperada = recuperar(chavePrimaria);
		if (entidadeRecuperada != null) {
			try {
				return entityManager.merge(entidade);
			} catch (IllegalArgumentException iaex) {
				throw new EntidadeNaoEncontradaExcecao(iaex);
			}
		}
		throw new EntidadeNaoEncontradaExcecao();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E recuperar(PK chavePrimaria) throws EntidadeNaoEncontradaExcecao {
		E entity = (E) entityManager.find(getDomainClass(), chavePrimaria);
		if (entity == null) {
			throw new EntidadeNaoEncontradaExcecao();
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> listar() {
		return entityManager.createQuery("from " + getDomainClass().getSimpleName()).getResultList();
	}
	
}
