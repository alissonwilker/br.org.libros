package br.org.libros.cliente.view.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.org.libros.cliente.dto.ClienteDto;
import br.org.libros.cliente.model.business.facade.ClienteBusinessFacade;
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

    @Inject
    public ClienteController(ClienteBusinessFacade facade) {
        super(facade);
    }
    
	private static final long serialVersionUID = 1L;
	
	/**
	 * Cadastra um novo cliente.
	 * @param cpfCliente CPF do cliente a ser adicionado.
	 * @param nomeCliente nome do cliente a ser adicionado.
	 * @return página inicial da aplicação.
	 */
	public String adicionarCliente(String cpfCliente, String nomeCliente) {
		ClienteDto clienteDto = new ClienteDto(cpfCliente, nomeCliente);
		if (super.adicionar(clienteDto)) {
			return JsfUtils.getRedirecionamentoComMensagens(Pagina.app);
		}
		return "";
	}

}