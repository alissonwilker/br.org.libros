package br.org.libros.biblioteca.view.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.biblioteca.dto.BibliotecaDto;
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

	private static final long serialVersionUID = 1L;

	public String adicionarBiblioteca(String nomeBiblioteca) {
		BibliotecaDto bibliotecaDto = new BibliotecaDto(nomeBiblioteca);
		if (super.adicionar(bibliotecaDto)) {
			return JsfUtils.getRedirecionamentoComMensagens(Pagina.app);
		}
		return "";
	}

}