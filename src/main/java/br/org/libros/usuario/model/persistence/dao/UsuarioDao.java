package br.org.libros.usuario.model.persistence.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.comum.model.persistence.dao.LibrosAbstractDao;
import br.org.libros.usuario.model.persistence.entity.Usuario;

/**
 * 
 * @see br.org.libros.comum.model.persistence.dao.LibrosAbstractDao
 */
@Named
@RequestScoped
public class UsuarioDao extends LibrosAbstractDao<Usuario, Integer> {
	private static final long serialVersionUID = 1L;

}
