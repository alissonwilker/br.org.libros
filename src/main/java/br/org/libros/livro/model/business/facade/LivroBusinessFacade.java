package br.org.libros.livro.model.business.facade;

import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import br.org.libros.comum.model.business.facade.AbstractBusinessFacade;
import br.org.libros.comum.model.persistence.entity.Livro;
import br.org.libros.livro.dto.LivroDto;
import br.org.libros.livro.dto.mapper.ILivroMapper;

/**
 * 
 * @see br.org.libros.comum.model.business.facade.AbstractBusinessFacade
 */
@Stateless
@Transactional
@PermitAll
public class LivroBusinessFacade extends AbstractBusinessFacade<Livro, LivroDto, Integer> {

	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {
		this.mapper = ILivroMapper.INSTANCE;
	}
}
