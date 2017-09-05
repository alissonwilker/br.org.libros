package br.org.libros.comum.api;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.org.libros.comum.dto.IDto;
import br.org.libros.comum.exception.EntidadeJaExisteExcecao;
import br.org.libros.comum.exception.EntidadeNaoEncontradaExcecao;
import br.org.libros.comum.model.business.facade.IBusinessFacade;

/**
 * Classe abstrata que contém comportamento padrão de APIs do sistema.
 *
 * @param <D>
 *            tipo do DTO que representa a Entidade.
 * 
 * @see br.org.libros.comum.model.business.facade.AbstractBusinessFacade
 */
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public abstract class AbstractApi<D extends IDto> {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	protected String apiPath;
	
	@Inject
	protected IBusinessFacade<D, Integer> businessFacade;

	public Response adicionar(D dto) {
		try {
			dto = businessFacade.adicionar(dto);
			return Response.created(new URI(apiPath + "/" + dto.getId())).build();
		} catch (ConstraintViolationException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (EntidadeNaoEncontradaExcecao e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (EntidadeJaExisteExcecao e) {
			return Response.status(Status.CONFLICT).build();
		} catch (Throwable th) {
			logger.error(th.getMessage(), th);
			return Response.serverError().build();
		}
	}

	public Response listar() {
		try {
			List<D> dtos = businessFacade.listar();
			return Response.ok(dtos).build();
		} catch (Throwable th) {
			logger.error(th.getMessage(), th);
			return Response.serverError().build();
		}
	}

	public Response remover(Integer chavePrimaria) {
		try {
			businessFacade.remover(chavePrimaria);
			return Response.ok().build();
		} catch (EntidadeNaoEncontradaExcecao e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (Throwable th) {
			logger.error(th.getMessage(), th);
			return Response.serverError().build();
		}
	}

	public Response atualizar(Integer chavePrimaria, D dto) {
		try {
			if (dto == null || chavePrimaria != dto.getId()) {
				return Response.status(Status.BAD_REQUEST).build();
			}
			dto = businessFacade.atualizar(chavePrimaria, dto);
			return Response.ok(dto).build();
		} catch (ConstraintViolationException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (EntidadeNaoEncontradaExcecao e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (EntidadeJaExisteExcecao e) {
			return Response.status(Status.CONFLICT).build();
		} catch (Throwable th) {
			logger.error(th.getMessage(), th);
			return Response.serverError().build();
		}
	}

	public Response recuperar(Integer chavePrimaria) {
		try {
			D dto = businessFacade.recuperar(chavePrimaria);
			return Response.ok(dto).build();
		} catch (EntidadeNaoEncontradaExcecao e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (Throwable th) {
			logger.error(th.getMessage(), th);
			return Response.serverError().build();
		}
	}
}
