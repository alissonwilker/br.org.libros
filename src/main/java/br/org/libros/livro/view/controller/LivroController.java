package br.org.libros.livro.view.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.org.libros.comum.model.business.facade.IBusinessFacade;
import br.org.libros.comum.view.controller.AbstractController;
import br.org.libros.comum.view.utils.JsfUtils;
import br.org.libros.comum.view.utils.JsfUtils.Pagina;
import br.org.libros.livro.dto.LivroDto;

/**
 * 
 * @see br.org.libros.comum.view.controller.AbstractController
 */
@ManagedBean
@ViewScoped
public class LivroController extends AbstractController<LivroDto, Integer> {

	private static final long serialVersionUID = 1L;

	@PostConstruct
	@Inject
	public void init(IBusinessFacade<LivroDto, Integer> businessFacade) {
		this.businessFacade = businessFacade;
	}
	
	/**
	 * Cadastra um novo livro.
	 * @param isbnLivro ISBN do livro a ser adicionado.
	 * @param nomeLivro nome do livro a ser adicionado.
	 * @return página inicial da aplicação.
	 */
	public String adicionarLivro(String isbnLivro, String nomeLivro) {
		LivroDto livroDto = new LivroDto(isbnLivro, nomeLivro);
		if (super.adicionar(livroDto)) {
			return JsfUtils.getRedirecionamentoComMensagens(Pagina.app);
		}
		return "";
	}

}