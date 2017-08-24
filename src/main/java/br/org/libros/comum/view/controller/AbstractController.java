package br.org.libros.comum.view.controller;

import java.io.Serializable;
import java.util.List;

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
	
	private List<D> entidades;

    protected IBusinessFacade<D, PK> businessFacade;
    
    public AbstractController(IBusinessFacade<D, PK> facade) {
        this.businessFacade = facade;
    }

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
			this.businessFacade.adicionar(dto);
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
			this.businessFacade.remover(dto);
			adicionarMensagemSucesso();
		} catch (EntidadeNaoEncontradaExcecao e) {
			adicionarMensagemItemNaoEncontrado();
		}
	}

	/**
	 * Carrega os registros de Entidade cadastrados na base de dados e armazena-os na propriedade 'entidades'.
	 * 
	 */
	public void carregarEntidades() {
		this.entidades = this.businessFacade.listar();
	}

	private void adicionarMensagemItemNaoEncontrado() {
		FacesMessageUtils.addInfoFacesMessage("excecao.itemNaoEncontrado");
	}

	private void adicionarMensagemSucesso() {
		FacesMessageUtils.addInfoFacesMessage("app.sucesso");
	}

	public List<D> getEntidades() {
		return this.entidades;
	}

}
