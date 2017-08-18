package br.org.libros.livro.view.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.comum.view.controller.AbstractController;
import br.org.libros.comum.view.utils.JsfUtils;
import br.org.libros.comum.view.utils.JsfUtils.Pagina;
import br.org.libros.livro.dto.LivroDto;

@Named
@RequestScoped
public class LivrosController extends AbstractController<LivroDto, Integer> {

	private static final long serialVersionUID = 1L;

	public String adicionarLivro(String isbnLivro, String nomeLivro) {
		LivroDto livroDto = new LivroDto(isbnLivro, nomeLivro);
		if (super.adicionar(livroDto)) {
			return JsfUtils.getRedirecionamentoComMensagens(Pagina.app);
		}
		return "";
	}

}