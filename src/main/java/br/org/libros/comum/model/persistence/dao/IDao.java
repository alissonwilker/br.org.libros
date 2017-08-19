package br.org.libros.comum.model.persistence.dao;

import java.io.Serializable;
import java.util.List;

import br.org.libros.comum.exception.EntidadeJaExisteExcecao;
import br.org.libros.comum.exception.EntidadeNaoEncontradaExcecao;

/**
 * Interface padrão de um DAO.
 *
 * @param <E> tipo da Entidade.
 * @param <PK> tipo da chave primária da Entidade.
 */
public interface IDao<E, PK extends Serializable> {

	public E adicionar(E entidade) throws EntidadeJaExisteExcecao;

	public List<E> listar();

	public void remover(E entidade) throws EntidadeNaoEncontradaExcecao;

	public void remover(PK chavePrimaria) throws EntidadeNaoEncontradaExcecao;

	public E atualizar(E entidade) throws EntidadeNaoEncontradaExcecao;

	public E recuperar(PK chavePrimaria) throws EntidadeNaoEncontradaExcecao;

	public E atualizar(PK chavePrimaria, E entidade) throws EntidadeNaoEncontradaExcecao;

}
