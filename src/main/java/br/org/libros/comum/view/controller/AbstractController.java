package br.org.libros.comum.view.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.org.libros.comum.exception.EntidadeJaExisteExcecao;
import br.org.libros.comum.exception.EntidadeNaoEncontradaExcecao;
import br.org.libros.comum.model.business.facade.IBusinessFacade;
import br.org.libros.comum.view.utils.FacesMessageUtils;

/**
 * Classe abstrata que representa um Controlador chamado pela página web para
 * acionar o Modelo. Este também é responsável pelos fluxos de navegação de
 * páginas.
 *
 * @param <D>
 *            tipo do DTO que representa a Entidade.
 * @param <PK>
 *            tipo da chave primária da Entidade.
 */
public abstract class AbstractController<D, PK extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IBusinessFacade<D, PK> businessFacade;

	/**
	 * Cadastra uma Entidade representada pelo DTO.
	 * 
	 * @param dto
	 *            o DTO que representa a Entidade a ser adicionada.
	 * @return <i>true</i> se a Entidade foi adicionada com sucesso.
	 *         <i>false</i>, caso contrário.
	 */
	public boolean adicionar(D dto) {
		try {
			businessFacade.adicionar(dto);
			adicionarMensagemSucesso();
			return true;
		} catch (EntidadeJaExisteExcecao e) {
			FacesMessageUtils.addInfoFacesMessage("excecao.itemJaCadastrado");
			return false;
		}
	}

	/**
	 * Remove uma Entidade representada pelo DTO.
	 * 
	 * @param dto
	 *            o DTO que representa a Entidade a ser removida.
	 */
	public void remover(D dto) {
		try {
			businessFacade.remover(dto);
			adicionarMensagemSucesso();
		} catch (EntidadeNaoEncontradaExcecao e) {
			adicionarMensagemItemNaoEncontrado();
		}
	}

	/**
	 * Lista os registros de Entidade cadastrados na base de dados.
	 * 
	 * @return uma lista contendo todos os registros da Entidade na base de
	 *         dados.
	 */
	public List<D> getItens() {
		return businessFacade.listar();
	}

	/**
	 * Recupera um DTO que representa uma Entidade identificada pela chave
	 * primária.
	 * 
	 * @param chavePrimaria
	 *            a chave primária da Entidade cujo DTO deve ser retornado.
	 * @return o DTO que representa a Entidade identificada pela chave primária.
	 */
	public D getItem(PK chavePrimaria) {
		try {
			return businessFacade.recuperar(chavePrimaria);
		} catch (EntidadeNaoEncontradaExcecao e) {
			adicionarMensagemItemNaoEncontrado();
			return null;
		}
	}

	private void adicionarMensagemItemNaoEncontrado() {
		FacesMessageUtils.addInfoFacesMessage("excecao.itemNaoEncontrado");
	}

	private void adicionarMensagemSucesso() {
		FacesMessageUtils.addInfoFacesMessage("app.sucesso");
	}

}
