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

import br.org.libros.biblioteca.dto.ClienteDto;
import br.org.libros.comum.api.AbstractApi;
import br.org.libros.comum.exception.EntidadeJaExisteExcecao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @see br.org.libros.comum.api.AbstractApi
 */
@Path("/clientes")
@Api(value = "clientes")
public class ClienteApi extends AbstractApi<ClienteDto, Integer> {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@POST
	@Path("/{cpfCliente}/{nomeCliente}")
	@ApiOperation(value = "Adicionar um cliente")
	public Response adicionar(@PathParam("cpfCliente") String cpfCliente,
			@PathParam("nomeCliente") String nomeCliente) {
		ClienteDto clienteDto = new ClienteDto(cpfCliente, nomeCliente);
		try {
			clienteDto = businessFacade.adicionar(clienteDto);
			return Response.created(new URI("/clientes/" + clienteDto.getId())).build();
		} catch (EntidadeJaExisteExcecao e) {
			return Response.status(Status.CONFLICT).build();
		} catch (URISyntaxException e) {
			logger.error(e.getMessage(), e);
			return Response.serverError().build();
		}
	}

	@Override
	@GET
	@ApiOperation(value = "Recuperar os clientes", response = ClienteDto.class, responseContainer = "List")
	public Response listar() {
		return super.listar();
	}

	@Override
	@DELETE
	@Path("/{idCliente}")
	@ApiOperation(value = "Remover um cliente")
	public Response remover(@PathParam("idCliente") Integer idCliente) {
		return super.remover(idCliente);
	}

	@PUT
	@Path("/{idCliente}/atualizar/{cpfCliente}/{nomeCliente}")
	@ApiOperation(value = "Atualizar um cliente", response = ClienteDto.class)
	public Response atualizar(@PathParam("idCliente") Integer idCliente, @PathParam("cpfCliente") String cpfCliente,
			@PathParam("nomeCliente") String nomeCliente) {
		ClienteDto clienteDto = new ClienteDto(cpfCliente, nomeCliente);
		clienteDto.setId(idCliente);
		return super.atualizar(idCliente, clienteDto);
	}

	@Override
	@GET
	@Path("/{idCliente}")
	@ApiOperation(value = "Recuperar um cliente", response = ClienteDto.class)
	public Response recuperar(@PathParam("idCliente") Integer idCliente) {
		return super.recuperar(idCliente);
	}

}