package br.org.libros.comum.model.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.org.libros.comum.excecao.EntidadeJaExisteException;
import br.org.libros.comum.excecao.EntidadeNaoEncontradaException;
import br.org.libros.comum.model.persistence.dao.IDao;

/**
 * Classe abstrata que contém implementação de comportamento padrão da camada negocial de um módulo.
 *
 * @param <E> tipo da Entidade.
 * @param <PK> tipo da chave primária da Entidade.
 * 
 * @see br.org.libros.comum.model.business.IBusiness
 */
public abstract class AbstractBusiness<E, PK extends Serializable> implements IBusiness<E, PK>, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IDao<E, PK> dao;

	@Override
	public E adicionar(E entidade) throws EntidadeJaExisteException, EntidadeNaoEncontradaException {
		return dao.adicionar(entidade);
	}

	@Override
	public void remover(E entidade) throws EntidadeNaoEncontradaException {
		dao.remover(entidade);
	}

	@Override
	public void remover(PK chavePrimaria) throws EntidadeNaoEncontradaException {
		dao.remover(chavePrimaria);
	}

	@Override
	public E atualizar(E entidade) throws EntidadeNaoEncontradaException, EntidadeJaExisteException {
		return dao.atualizar(entidade);
	}

	@Override
	public List<E> listar() {
		return dao.listar();
	}

	@Override
	public E recuperar(PK chavePrimaria) throws EntidadeNaoEncontradaException {
		return dao.recuperar(chavePrimaria);
	}
	
}
