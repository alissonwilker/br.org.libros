package br.org.libros.biblioteca.model.business.facade;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.org.libros.biblioteca.dto.BibliotecaDto;
import br.org.libros.biblioteca.dto.mapper.IBibliotecaMapper;
import br.org.libros.biblioteca.model.persistence.entity.Biblioteca;
import br.org.libros.comum.model.business.facade.AbstractBusinessFacade;

/**
 * 
 * @see br.org.libros.comum.model.business.facade.AbstractBusinessFacade
 */
@Named
@RequestScoped
@Transactional
public class BibliotecaBusinessFacade extends AbstractBusinessFacade<Biblioteca, BibliotecaDto, Integer> {

	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {
		mapper = IBibliotecaMapper.INSTANCE;
	}

}
