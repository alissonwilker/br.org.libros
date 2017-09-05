package br.org.libros.biblioteca.view.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.org.libros.biblioteca.dto.LivroBibliotecaDto;
import br.org.libros.comum.model.business.facade.IBusinessFacade;
import br.org.libros.comum.view.controller.AbstractController;

/**
 * 
 * @see br.org.libros.comum.view.controller.AbstractController
 */
@ManagedBean
@ViewScoped
public class LivroBibliotecaController extends AbstractController<LivroBibliotecaDto, Integer> {

	private static final long serialVersionUID = 1L;

	@PostConstruct
	@Inject
	public void init(IBusinessFacade<LivroBibliotecaDto, Integer> businessFacade) {
		this.businessFacade = businessFacade;
	}
	
}