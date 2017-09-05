package br.org.libros.livro.api;

import java.net.URISyntaxException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.org.libros.comum.api.AbstractApi;
import br.org.libros.comum.excecao.EntidadeJaExisteException;
import br.org.libros.comum.excecao.EntidadeNaoEncontradaException;
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
public class LivroApi extends AbstractApi<LivroDto, Integer> {

	protected static final String PATH = "/livros";

	public LivroApi() {
		apiPath = PATH;
	}

	@Override
	@POST
	@ApiOperation(value = "Adicionar um livro")
	public Response adicionar(@ApiParam(value = "livroDto") LivroDto livroDto) throws EntidadeJaExisteException, EntidadeNaoEncontradaException, URISyntaxException {
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
	public Response remover(@PathParam("idLivro") Integer idLivro) throws EntidadeNaoEncontradaException {
		return super.remover(idLivro);
	}

	@Override
	@PUT
	@ApiOperation(value = "Atualizar um livro", response = LivroDto.class)
	public Response atualizar(@ApiParam(value = "livroDto") LivroDto livroDto) throws EntidadeNaoEncontradaException, EntidadeJaExisteException {
		return super.atualizar(livroDto);
	}

	@Override
	@GET
	@Path("/{idLivro}")
	@ApiOperation(value = "Recuperar um livro", response = LivroDto.class)
	public Response recuperar(@PathParam("idLivro") Integer idLivro) throws EntidadeNaoEncontradaException {
		return super.recuperar(idLivro);
	}

}