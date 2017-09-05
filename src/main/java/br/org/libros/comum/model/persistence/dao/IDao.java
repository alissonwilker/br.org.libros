package br.org.libros.comum.model.persistence.dao;

import java.io.Serializable;
import java.util.List;

import br.org.libros.comum.excecao.EntidadeJaExisteException;
import br.org.libros.comum.excecao.EntidadeNaoEncontradaException;

/**
 * Interface padrão de um DAO.
 *
 * @param <E>
 *            tipo da Entidade.
 * @param <PK>
 *            tipo da chave primária da Entidade.
 */
public interface IDao<E, PK extends Serializable> {

	/**
	 * Adiciona um registro da Entidade na base de dados.
	 * 
	 * @param entidade
	 *            a Entidade a ser adicionada na base.
	 * @return um objeto gerenciado da Entidade adicionada.
	 * @throws EntidadeJaExisteException
	 *             se a Entidade já existir na base.
	 */
	public E adicionar(E entidade) throws EntidadeJaExisteException;

	/**
	 * Lista todos os registros da Entidade que existem na base da dados.
	 * 
	 * @return uma lista com os registros da Entidade.
	 */
	public List<E> listar();

	/**
	 * Remove uma Entidade da base de dados.
	 * 
	 * @param entidade
	 *            a Entidade a ser removida.
	 * @throws EntidadeNaoEncontradaException
	 *             se a Entidade não for encontrada para remoção.
	 */
	public void remover(E entidade) throws EntidadeNaoEncontradaException;

	/**
	 * Remove uma Entidade a partir da chave primária.
	 * 
	 * @param chavePrimaria
	 *            a chave primária da Entidade a ser removida.
	 * @throws EntidadeNaoEncontradaException
	 *             se a Entidade correspondente à chave primária não for
	 *             encontrada.
	 */
	public void remover(PK chavePrimaria) throws EntidadeNaoEncontradaException;

	/**
	 * Atualiza o registro de uma Entidade na base de dados.
	 * 
	 * @param entidade
	 *            a Entidade gerenciada a ser atualizada na base.
	 * @return um objeto gerenciado da Entidade atualizada.
	 * @throws EntidadeNaoEncontradaException
	 *             se a Entidade não for encontrada na base para atualização.
	 * @throws EntidadeJaExisteException
	 *             se ocorrer violação de constraint.
	 */
	public E atualizar(E entidade) throws EntidadeNaoEncontradaException, EntidadeJaExisteException;

	/**
	 * Recupera uma Entidade da base de dados a partir da chave primária.
	 * 
	 * @param chavePrimaria
	 *            a chave primária da Entidade a ser recuperada.
	 * @return um objeto gerenciado da Entidade recuperada.
	 * @throws EntidadeNaoEncontradaException
	 *             se a Entidade não for encontrada na base.
	 */
	public E recuperar(PK chavePrimaria) throws EntidadeNaoEncontradaException;

}
