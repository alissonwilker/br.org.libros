package br.org.libros.comum.api.excecao.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.org.libros.comum.excecao.EntidadeJaExisteExcecao;

@Provider
public class EntidadeJaExisteMapper implements ExceptionMapper<EntidadeJaExisteExcecao> {

	@Override
	public Response toResponse(EntidadeJaExisteExcecao exception) {
		return Response.status(Response.Status.CONFLICT).build();
	}

}
