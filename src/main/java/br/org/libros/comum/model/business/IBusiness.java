package br.org.libros.comum.model.business;

import java.io.Serializable;
import java.util.List;

import br.org.libros.comum.excecao.EntidadeJaExisteException;
import br.org.libros.comum.excecao.EntidadeNaoEncontradaException;

/**
 * Interface padrão da camada negocial de um módulo.
 *
 * @param <E> tipo da Entidade.
 * @param <PK> tipo da chave primária da Entidade.
 * 
 * @see br.org.libros.comum.model.persistence.dao.IDao
 */
public interface IBusiness<E, PK extends Serializable> {

	public E adicionar(E entidade) throws EntidadeJaExisteException, EntidadeNaoEncontradaException;

	public List<E> listar();

	public void remover(E entidade) throws EntidadeNaoEncontradaException;

	public void remover(PK chavePrimaria) throws EntidadeNaoEncontradaException;

	public E atualizar(E entidade) throws EntidadeNaoEncontradaException, EntidadeJaExisteException;

	public E recuperar(PK chavePrimaria) throws EntidadeNaoEncontradaException;

}
