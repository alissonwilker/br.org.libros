package br.org.libros.cliente.view.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.cliente.dto.ClienteDto;
import br.org.libros.comum.view.controller.AbstractController;
import br.org.libros.comum.view.utils.JsfUtils;
import br.org.libros.comum.view.utils.JsfUtils.Pagina;

/**
 * 
 * @see br.org.libros.comum.view.controller.AbstractController
 */
@Named
@RequestScoped
public class ClienteController extends AbstractController<ClienteDto, Integer> {

	private static final long serialVersionUID = 1L;
	
	public String adicionarCliente(String cpfCliente, String nomeCliente) {
		ClienteDto clienteDto = new ClienteDto(cpfCliente, nomeCliente);
		if (super.adicionar(clienteDto)) {
			return JsfUtils.getRedirecionamentoComMensagens(Pagina.app);
		}
		return "";
	}

}