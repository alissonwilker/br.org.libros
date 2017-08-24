package br.org.libros.biblioteca.view.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.org.libros.biblioteca.dto.BibliotecaDto;
import br.org.libros.biblioteca.model.business.facade.BibliotecaBusinessFacade;
import br.org.libros.comum.view.controller.AbstractController;
import br.org.libros.comum.view.utils.JsfUtils;
import br.org.libros.comum.view.utils.JsfUtils.Pagina;

/**
 * 
 * @see br.org.libros.comum.view.controller.AbstractController
 */
@Named
@RequestScoped
public class BibliotecaController extends AbstractController<BibliotecaDto, Integer> {

    @Inject
    public BibliotecaController(BibliotecaBusinessFacade facade) {
        super(facade);
    }
    
    // @PostConstruct
    // public void init() {
    // this.businessFacade = this.bf;
    // }


	private static final long serialVersionUID = 1L;

	/**
	 * Cadastra uma nova biblioteca.
	 * @param nomeBiblioteca nome da biblioteca a ser adicionada.
	 * @return página inicial da aplicação.
	 */
	public String adicionarBiblioteca(String nomeBiblioteca) {
		BibliotecaDto bibliotecaDto = new BibliotecaDto(nomeBiblioteca);
		if (super.adicionar(bibliotecaDto)) {
			return JsfUtils.getRedirecionamentoComMensagens(Pagina.app);
		}
		return "";
	}

}