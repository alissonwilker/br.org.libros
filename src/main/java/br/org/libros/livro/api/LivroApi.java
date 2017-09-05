package br.org.libros.livro.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.org.libros.comum.api.AbstractApi;
import br.org.libros.livro.dto.LivroDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @see br.org.libros.comum.api.AbstractApi
 */
@Path(LivroApi.PATH)
@Api(LivroApi.PATH)
public class LivroApi extends AbstractApi<LivroDto> {

	protected static final String PATH = "/livros";

	public LivroApi() {
		apiPath = PATH;
	}

	@Override
	@POST
	@ApiOperation(value = "Adicionar um livro")
	public Response adicionar(@ApiParam(value = "livroDto") LivroDto livroDto) {
		return super.adicionar(livroDto);
	}

	@Override
	@GET
	@ApiOperation(value = "Recuperar os livros", response = LivroDto.class, responseContainer = "List")
	public Response listar() {
		return super.listar();
	}

	@Override
	@DELETE
	@Path("/{idLivro}")
	@ApiOperation(value = "Remover um livro")
	public Response remover(@PathParam("idLivro") Integer idLivro) {
		return super.remover(idLivro);
	}

	@Override
	@PUT
	@Path("/{idLivro}")
	@ApiOperation(value = "Atualizar um livro", response = LivroDto.class)
	public Response atualizar(@PathParam("idLivro") Integer idLivro, @ApiParam(value = "livroDto") LivroDto livroDto) {
		return super.atualizar(idLivro, livroDto);
	}

	@Override
	@GET
	@Path("/{idLivro}")
	@ApiOperation(value = "Recuperar um livro", response = LivroDto.class)
	public Response recuperar(@PathParam("idLivro") Integer idLivro) {
		return super.recuperar(idLivro);
	}

}