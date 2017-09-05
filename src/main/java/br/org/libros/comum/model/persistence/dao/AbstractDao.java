package br.org.libros.comum.model.persistence.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;

import br.org.libros.comum.excecao.EntidadeJaExisteException;
import br.org.libros.comum.excecao.EntidadeNaoEncontradaException;

/**
 * Classe abstrata que implementa comportamento padrão de um DAO.
 *
 * @param <E>
 *            tipo da Entidade.
 * @param <PK>
 *            tipo da chave primária da Entidade.
 * 
 * @see br.org.libros.comum.model.persistence.dao.IDao
 */
public abstract class AbstractDao<E, PK extends Serializable> implements IDao<E, PK>, Serializable {

	private static final long serialVersionUID = 1L;

	protected EntityManager entityManager;
	private Class<?> domain;

	protected void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

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
	public E adicionar(E entidade) throws EntidadeJaExisteException {
		try {
			entityManager.persist(entidade);
			return entidade;
		} catch (PersistenceException eeex) {
			if (eeex.getCause() instanceof ConstraintViolationException) {
				throw new EntidadeJaExisteException(eeex);
			} else {
				throw eeex;
			}
		}
	}

	@Override
	public void remover(PK chavePrimaria) throws EntidadeNaoEncontradaException {
		E entidade = recuperar(chavePrimaria);
		remover(entidade);
	}

	@Override
	public void remover(E entidade) throws EntidadeNaoEncontradaException {
		try {
			entidade = entityManager.merge(entidade);
			entityManager.remove(entidade);
			entityManager.flush(); // requerido para mandar mensagem JMS pelo
									// EntityListener da Entidade.
		} catch (IllegalArgumentException iaex) {
			throw new EntidadeNaoEncontradaException(iaex);
		}
	}

	@Override
	public E atualizar(E entidade) throws EntidadeNaoEncontradaException, EntidadeJaExisteException {
		try {
			E entidadeAtualizada = entityManager.merge(entidade);
			entityManager.flush();
			return entidadeAtualizada;
		} catch (IllegalArgumentException iaex) {
			throw new EntidadeNaoEncontradaException(iaex);
		} catch (PersistenceException eeex) {
			if (eeex.getCause() instanceof ConstraintViolationException) {
				throw new EntidadeJaExisteException(eeex);
			} else {
				throw eeex;
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E recuperar(PK chavePrimaria) throws EntidadeNaoEncontradaException {
		E entity = (E) entityManager.find(getDomainClass(), chavePrimaria);
		if (entity == null) {
			throw new EntidadeNaoEncontradaException();
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> listar() {
		return entityManager.createQuery("from " + getDomainClass().getSimpleName()).getResultList();
	}

}
