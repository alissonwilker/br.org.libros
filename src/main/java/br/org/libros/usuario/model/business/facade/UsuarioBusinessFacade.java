package br.org.libros.usuario.model.business.facade;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.org.libros.comum.model.business.facade.AbstractBusinessFacade;
import br.org.libros.comum.model.persistence.entity.Usuario;
import br.org.libros.usuario.dto.UsuarioDto;
import br.org.libros.usuario.dto.mapper.IUsuarioMapper;

/**
 * 
 * @see br.org.libros.comum.model.business.facade.AbstractBusinessFacade
 */
@Named
@RequestScoped
@Transactional
public class UsuarioBusinessFacade extends AbstractBusinessFacade<Usuario, UsuarioDto, Integer> {

	private static final long serialVersionUID = 1L;

	public UsuarioBusinessFacade() {
		mapper = IUsuarioMapper.INSTANCE;
	}

}