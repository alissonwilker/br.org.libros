package br.org.libros.biblioteca.api;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.org.libros.biblioteca.dto.BibliotecaDto;
import br.org.libros.comum.api.AbstractApi;
import br.org.libros.comum.exception.EntidadeJaExisteExcecao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @see br.org.libros.comum.api.AbstractApi
 */
@Path("/bibliotecas")
@Api(value = "bibliotecas")
public class BibliotecaApi extends AbstractApi<BibliotecaDto, Integer> {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@POST
	@Path("/{nomeBiblioteca}")
	@ApiOperation(value = "Adicionar uma biblioteca")
	public Response adicionar(@PathParam("nomeBiblioteca") String nomeBiblioteca) {
		BibliotecaDto bibliotecaDto = new BibliotecaDto(nomeBiblioteca);
		try {
			bibliotecaDto = businessFacade.adicionar(bibliotecaDto);
			return Response.created(new URI("/bibliotecas/" + bibliotecaDto.getId())).build();
		} catch (EntidadeJaExisteExcecao e) {
			return Response.status(Status.CONFLICT).build();
		} catch (URISyntaxException e) {
			logger.error(e.getMessage(), e);
			return Response.serverError().build();
		}
	}

	@Override
	@GET
	@ApiOperation(value = "Recuperar as bibliotecas", response = BibliotecaDto.class, responseContainer = "List")
	public Response listar() {
		return super.listar();
	}

	@Override
	@DELETE
	@Path("/{idBiblioteca}")
	@ApiOperation(value = "Remover uma biblioteca")
	public Response remover(@PathParam("idBiblioteca") Integer idBiblioteca) {
		return super.remover(idBiblioteca);
	}

	@Override
	@PUT
	@Path("/{idBiblioteca}")
	@ApiOperation(value = "Atualizar uma biblioteca", response = BibliotecaDto.class)
	public Response atualizar(@PathParam("idBiblioteca") Integer idBiblioteca,
			@ApiParam(value="bibliotecaDto") BibliotecaDto bibliotecaDto) {
		if (bibliotecaDto == null || idBiblioteca != bibliotecaDto.getId()) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		return super.atualizar(idBiblioteca, bibliotecaDto);
	}

	@Override
	@GET
	@Path("/{idBiblioteca}")
	@ApiOperation(value = "Recuperar uma biblioteca", response = BibliotecaDto.class)
	public Response recuperar(@PathParam("idBiblioteca") Integer idBiblioteca) {
		return super.recuperar(idBiblioteca);
	}

}