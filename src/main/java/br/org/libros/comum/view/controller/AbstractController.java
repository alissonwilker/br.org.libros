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
 * @param <D> tipo do DTO que representa a Entidade.
 * @param <PK> tipo da chave primária da Entidade.
 */
public abstract class AbstractController<D, PK extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IBusinessFacade<D, PK> businessFacade;

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

	public void remover(D dto) {
		try {
			businessFacade.remover(dto);
			adicionarMensagemSucesso();
		} catch (EntidadeNaoEncontradaExcecao e) {
			adicionarMensagemItemNaoEncontrado();
		}
	}

	public List<D> getItens() {
		return businessFacade.listar();
	}

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
