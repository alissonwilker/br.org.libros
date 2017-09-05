package br.org.libros.biblioteca.view.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.org.libros.biblioteca.dto.ClienteDto;
import br.org.libros.comum.model.business.facade.IBusinessFacade;
import br.org.libros.comum.view.controller.AbstractController;
import br.org.libros.comum.view.utils.JsfUtils;
import br.org.libros.comum.view.utils.JsfUtils.Pagina;

/**
 * 
 * @see br.org.libros.comum.view.controller.AbstractController
 */
@ManagedBean
@ViewScoped
public class ClienteController extends AbstractController<ClienteDto, Integer> {

	private static final long serialVersionUID = 1L;

	@PostConstruct
	@Inject
	public void init(IBusinessFacade<ClienteDto, Integer> businessFacade) {
		this.businessFacade = businessFacade;
	}

	/**
	 * Cadastra um novo cliente.
	 * 
	 * @param cpfCliente
	 *            CPF do cliente a ser adicionado.
	 * @param nomeCliente
	 *            nome do cliente a ser adicionado.
	 * @return página inicial da aplicação.
	 */
	public String adicionarCliente(String cpfCliente, String nomeCliente) {
		ClienteDto clienteDto = new ClienteDto(cpfCliente, nomeCliente);
		if (super.adicionar(clienteDto)) {
			return JsfUtils.getRedirecionamentoComMensagens(Pagina.app);
		}
		return null;
	}

}