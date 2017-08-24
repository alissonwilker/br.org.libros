package br.org.libros.livro.view.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.org.libros.comum.view.controller.AbstractController;
import br.org.libros.comum.view.utils.JsfUtils;
import br.org.libros.comum.view.utils.JsfUtils.Pagina;
import br.org.libros.livro.dto.LivroDto;
import br.org.libros.livro.model.business.facade.LivroBusinessFacade;

/**
 * 
 * @see br.org.libros.comum.view.controller.AbstractController
 */
@Named
@RequestScoped
public class LivroController extends AbstractController<LivroDto, Integer> {

    @Inject
    public LivroController(LivroBusinessFacade facade) {
        super(facade);
    }

    private static final long serialVersionUID = 1L;
    
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