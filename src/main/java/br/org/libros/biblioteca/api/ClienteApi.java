package br.org.libros.biblioteca.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.org.libros.biblioteca.dto.ClienteDto;
import br.org.libros.comum.api.AbstractApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @see br.org.libros.comum.api.AbstractApi
 */
@Path(ClienteApi.PATH)
@Api(ClienteApi.PATH)
public class ClienteApi extends AbstractApi<ClienteDto> {

	protected static final String PATH = "/clientes";

	public ClienteApi() {
		apiPath = PATH;
	}

	@Override
	@POST
	@ApiOperation(value = "Adicionar um cliente")
	public Response adicionar(@ApiParam(value = "clienteDto") ClienteDto clienteDto) {
		return super.adicionar(clienteDto);
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

	@Override
	@PUT
	@Path("/{idCliente}")
	@ApiOperation(value = "Atualizar um cliente", response = ClienteDto.class)
	public Response atualizar(@PathParam("idCliente") Integer idCliente,
			@ApiParam(value = "clienteDto") ClienteDto clienteDto) {
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