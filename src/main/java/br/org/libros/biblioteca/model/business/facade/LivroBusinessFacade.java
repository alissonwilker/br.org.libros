package br.org.libros.biblioteca.model.business.facade;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.org.libros.biblioteca.dto.LivroDto;
import br.org.libros.biblioteca.dto.mapper.ILivroMapper;
import br.org.libros.biblioteca.model.persistente.entity.Livro;
import br.org.libros.comum.model.business.facade.AbstractBusinessFacade;

/**
 * 
 * @see br.org.libros.comum.model.business.facade.AbstractBusinessFacade
 */
@Named("LivroBibliotecaBusinessFacade")
@RequestScoped
@Transactional
public class LivroBusinessFacade extends AbstractBusinessFacade<Livro, LivroDto, Integer> {

	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {
		mapper = ILivroMapper.INSTANCE;
	}

}
