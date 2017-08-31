package br.org.libros.livro.api;

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

import br.org.libros.comum.api.AbstractApi;
import br.org.libros.comum.exception.EntidadeJaExisteExcecao;
import br.org.libros.livro.dto.LivroDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @see br.org.libros.comum.api.AbstractApi
 */
@Path("/livros")
@Api(value = "livros")
public class LivroApi extends AbstractApi<LivroDto, Integer> {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@POST
	@Path("/{isbnLivro}/{nomeLivro}")
	@ApiOperation(value = "Adicionar um livro")
	public Response adicionar(@PathParam("isbnLivro") String isbnLivro, @PathParam("nomeLivro") String nomeLivro) {
		LivroDto livroDto = new LivroDto(isbnLivro, nomeLivro);
		try {
			livroDto = businessFacade.adicionar(livroDto);
			return Response.created(new URI("/livros/" + livroDto.getId())).build();
		} catch (EntidadeJaExisteExcecao e) {
			return Response.status(Status.CONFLICT).build();
		} catch (URISyntaxException e) {
			logger.error(e.getMessage(), e);
			return Response.serverError().build();
		}
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

	@PUT
	@Path("/{idLivro}/atualizar/{isbnLivro}/{nomeLivro}")
	@ApiOperation(value = "Atualizar um livro", response = LivroDto.class)
	public Response atualizar(@PathParam("idLivro") Integer idLivro, @PathParam("isbnLivro") String isbnLivro,
			@PathParam("nomeLivro") String nomeLivro) {
		LivroDto livroDto = new LivroDto(isbnLivro, nomeLivro);
		livroDto.setId(idLivro);
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