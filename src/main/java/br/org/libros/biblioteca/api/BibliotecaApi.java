package br.org.libros.biblioteca.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.org.libros.biblioteca.dto.BibliotecaDto;
import br.org.libros.comum.api.AbstractApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @see br.org.libros.comum.api.AbstractApi
 */
@Path(BibliotecaApi.PATH)
@Api(BibliotecaApi.PATH)
public class BibliotecaApi extends AbstractApi<BibliotecaDto> {
	
	protected static final String PATH = "/bibliotecas";
	
	public BibliotecaApi() {
		apiPath = PATH;
	}
	
	@Override
	@POST
	@ApiOperation(value = "Adicionar uma biblioteca")
	public Response adicionar(@ApiParam(value = "bibliotecaDto") BibliotecaDto bibliotecaDto) {
		return super.adicionar(bibliotecaDto);
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
			@ApiParam(value = "bibliotecaDto") BibliotecaDto bibliotecaDto) {
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