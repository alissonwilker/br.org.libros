package br.org.libros.usuario.model.business;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.arquitetura.model.business.AbstractBusiness;
import br.org.libros.usuario.model.persistence.entity.Usuario;

/**
 * 
 * @see br.org.arquitetura.model.business.AbstractBusiness
 */
@Named
@RequestScoped
public class UsuarioBusiness extends AbstractBusiness<Usuario, Integer> {

	private static final long serialVersionUID = 1L;
}
