package br.org.libros.livro.model.business.facade;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.org.libros.comum.model.business.facade.AbstractBusinessFacade;
import br.org.libros.comum.model.persistence.entity.Livro;
import br.org.libros.livro.dto.LivroDto;
import br.org.libros.livro.dto.mapper.ILivroMapper;

/**
 * 
 * @see br.org.libros.comum.model.business.facade.AbstractBusinessFacade
 */
@Named
@RequestScoped
@Transactional
public class LivroBusinessFacade extends AbstractBusinessFacade<Livro, LivroDto, Integer> {

	private static final long serialVersionUID = 1L;

	public LivroBusinessFacade() {
		mapper = ILivroMapper.INSTANCE;
	}

}
