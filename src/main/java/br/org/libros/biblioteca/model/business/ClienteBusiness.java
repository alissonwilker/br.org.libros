package br.org.libros.biblioteca.model.business;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.biblioteca.model.persistence.entity.Cliente;
import br.org.libros.comum.model.business.AbstractBusiness;

/**
 * 
 * @see br.org.libros.comum.model.business.AbstractBusiness
 */
@Named
@RequestScoped
public class ClienteBusiness extends AbstractBusiness<Cliente, Integer> {

	private static final long serialVersionUID = 1L;
}
