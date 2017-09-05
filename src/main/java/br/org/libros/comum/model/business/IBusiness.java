package br.org.libros.comum.model.business;

import java.io.Serializable;
import java.util.List;

import br.org.libros.comum.exception.EntidadeJaExisteExcecao;
import br.org.libros.comum.exception.EntidadeNaoEncontradaExcecao;

/**
 * Interface padrão da camada negocial de um módulo.
 *
 * @param <E> tipo da Entidade.
 * @param <PK> tipo da chave primária da Entidade.
 * 
 * @see br.org.libros.comum.model.persistence.dao.IDao
 */
public interface IBusiness<E, PK extends Serializable> {

	public E adicionar(E entidade) throws EntidadeJaExisteExcecao, EntidadeNaoEncontradaExcecao;

	public List<E> listar();

	public void remover(E entidade) throws EntidadeNaoEncontradaExcecao;

	public void remover(PK chavePrimaria) throws EntidadeNaoEncontradaExcecao;

	public E atualizar(E entidade) throws EntidadeNaoEncontradaExcecao, EntidadeJaExisteExcecao;

	public E recuperar(PK chavePrimaria) throws EntidadeNaoEncontradaExcecao;

}
