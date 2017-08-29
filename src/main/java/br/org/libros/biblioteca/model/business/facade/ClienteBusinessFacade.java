package br.org.libros.biblioteca.model.business.facade;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.org.libros.biblioteca.dto.ClienteDto;
import br.org.libros.biblioteca.dto.mapper.IClienteMapper;
import br.org.libros.biblioteca.model.persistente.entity.Cliente;
import br.org.libros.comum.model.business.facade.AbstractBusinessFacade;

/**
 * 
 * @see br.org.libros.comum.model.business.facade.AbstractBusinessFacade
 */
@Named
@RequestScoped
@Transactional
public class ClienteBusinessFacade extends AbstractBusinessFacade<Cliente, ClienteDto, Integer> {

	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {
		mapper = IClienteMapper.INSTANCE;
	}

}
