package br.org.libros.comum.api.excecao.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.org.libros.comum.excecao.EntidadeNaoEncontradaException;

@Provider
public class EntidadeNaoEncontradaMapper implements ExceptionMapper<EntidadeNaoEncontradaException> {

	@Override
	public Response toResponse(EntidadeNaoEncontradaException exception) {
		return Response.status(Response.Status.NOT_FOUND).build();
	}

}
