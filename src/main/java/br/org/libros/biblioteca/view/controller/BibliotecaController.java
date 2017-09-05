package br.org.libros.biblioteca.view.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.org.libros.biblioteca.dto.BibliotecaDto;
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
public class BibliotecaController extends AbstractController<BibliotecaDto, Integer> {

	private static final long serialVersionUID = 1L;

	@PostConstruct
	@Inject
	public void init(IBusinessFacade<BibliotecaDto, Integer> businessFacade) {
		this.businessFacade = businessFacade;
	}

	/**
	 * Cadastra uma nova biblioteca.
	 * 
	 * @param nomeBiblioteca
	 *            nome da biblioteca a ser adicionada.
	 * @return página inicial da aplicação.
	 */
	public String adicionarBiblioteca(String nomeBiblioteca) {
		BibliotecaDto bibliotecaDto = new BibliotecaDto(nomeBiblioteca);
		if (super.adicionar(bibliotecaDto)) {
			return JsfUtils.getRedirecionamentoComMensagens(Pagina.app);
		}
		return null;
	}

}