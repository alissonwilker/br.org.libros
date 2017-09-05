package br.org.libros.comum.model.business.facade;

import java.io.Serializable;
import java.util.List;

import br.org.libros.comum.excecao.EntidadeJaExisteException;
import br.org.libros.comum.excecao.EntidadeNaoEncontradaException;

/**
 * Interface de uma fachada para a camada negocial de um módulo. A fachada é o
 * ponto de entrada para a camada negocial do módulo. Normalmente utilizada por
 * Controladores ou pela API.
 *
 * @param <D>
 *            tipo do DTO.
 * @param <PK>
 *            tipo da chave primária da Entidade representada pelo DTO.
 *            
 * @see br.org.libros.comum.model.business.IBusiness
 */
public interface IBusinessFacade<D, PK extends Serializable> extends Serializable {
	public D adicionar(D dto) throws EntidadeJaExisteException, EntidadeNaoEncontradaException;

	public List<D> listar();

	public void remover(D dto) throws EntidadeNaoEncontradaException;

	public void remover(PK chavePrimaria) throws EntidadeNaoEncontradaException;

	public D atualizar(D dto) throws EntidadeNaoEncontradaException, EntidadeJaExisteException;

	public D recuperar(PK chavePrimaria) throws EntidadeNaoEncontradaException;

}
