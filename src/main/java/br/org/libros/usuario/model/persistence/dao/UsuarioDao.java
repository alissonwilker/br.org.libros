package br.org.libros.usuario.model.persistence.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.comum.model.persistence.entity.Usuario;

/**
 * 
 * @see br.org.libros.usuario.model.persistence.dao.UsuarioAbstractDao
 */
@Named
@RequestScoped
public class UsuarioDao extends UsuarioAbstractDao<Usuario, Integer> {
	private static final long serialVersionUID = 1L;

}
