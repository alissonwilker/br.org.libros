package br.org.libros.cliente.model.business.facade;

import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import br.org.libros.cliente.dto.ClienteDto;
import br.org.libros.cliente.dto.mapper.IClienteMapper;
import br.org.libros.comum.model.business.facade.AbstractBusinessFacade;
import br.org.libros.comum.model.persistence.entity.Cliente;

/**
 * 
 * @see br.org.libros.comum.model.business.facade.AbstractBusinessFacade
 */
@Stateless
@Transactional
@PermitAll
public class ClienteBusinessFacade extends AbstractBusinessFacade<Cliente, ClienteDto, Integer> {

    
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {
		this.mapper = IClienteMapper.INSTANCE;
	}

}
