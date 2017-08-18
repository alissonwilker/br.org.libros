package br.org.libros.cliente.model.business;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.comum.model.business.AbstractBusiness;
import br.org.libros.comum.model.persistence.entity.Cliente;

@Named
@RequestScoped
public class ClienteBusiness extends AbstractBusiness<Cliente, Integer> {

	private static final long serialVersionUID = 1L;
}
