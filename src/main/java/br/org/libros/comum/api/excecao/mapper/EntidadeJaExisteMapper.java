package br.org.libros.comum.api.excecao.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.org.libros.comum.excecao.EntidadeJaExisteException;

@Provider
public class EntidadeJaExisteMapper implements ExceptionMapper<EntidadeJaExisteException> {

	@Override
	public Response toResponse(EntidadeJaExisteException exception) {
		return Response.status(Response.Status.CONFLICT).build();
	}

}
