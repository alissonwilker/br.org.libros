package br.org.libros.comum.api;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;

import br.org.libros.comum.exception.EntidadeNaoEncontradaExcecao;
import br.org.libros.comum.model.business.facade.IBusinessFacade;

/**
 * Classe abstrata que contém comportamento padrão de APIs do sistema.
 *
 * @param <D> tipo do DTO que representa a Entidade.
 * @param <PK> tipo da chave primária da Entidade.
 * 
 * @see br.org.libros.comum.model.business.facade.AbstractBusinessFacade
 */
public abstract class AbstractApi<D, PK extends Serializable> {
	protected Logger logger;

	@Inject
	protected IBusinessFacade<D, PK> businessFacade;

	public Response listar() {
		List<D> dtos = businessFacade.listar();
		return Response.ok(dtos).build();
	}
	
	public Response remover(PK chavePrimaria) {
		try {
			businessFacade.remover(chavePrimaria);
			return Response.ok().build();
		} catch (EntidadeNaoEncontradaExcecao e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	public Response atualizar(PK chavePrimaria, D dto) {
		try {
			dto = businessFacade.atualizar(chavePrimaria, dto);
			return Response.ok(dto).build();
		} catch (EntidadeNaoEncontradaExcecao e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	public Response recuperar(PK chavePrimaria) {
		try {
			D dto = businessFacade.recuperar(chavePrimaria);
			return Response.ok(dto).build();
		} catch (EntidadeNaoEncontradaExcecao e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
}
