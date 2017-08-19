package br.org.libros.cliente.model.business.facade;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.org.libros.cliente.dto.ClienteDto;
import br.org.libros.cliente.dto.mapper.IClienteMapper;
import br.org.libros.comum.model.business.facade.AbstractFacade;
import br.org.libros.comum.model.persistence.entity.Cliente;

/**
 * 
 * @see br.org.libros.comum.model.business.facade.AbstractFacade
 */
@Named
@RequestScoped
@Transactional
public class ClienteBusinessFacade extends AbstractFacade<Cliente, ClienteDto, Integer> {

	private static final long serialVersionUID = 1L;

	public ClienteBusinessFacade() {
		mapper = IClienteMapper.INSTANCE;
	}

}
