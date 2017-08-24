package br.org.libros.biblioteca.model.business.facade;

import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import br.org.libros.biblioteca.dto.BibliotecaDto;
import br.org.libros.biblioteca.dto.mapper.IBibliotecaMapper;
import br.org.libros.comum.model.business.facade.AbstractBusinessFacade;
import br.org.libros.comum.model.persistence.entity.Biblioteca;

/**
 * 
 * @see br.org.libros.comum.model.business.facade.AbstractBusinessFacade
 */
@Stateless
@Transactional
@PermitAll
public class BibliotecaBusinessFacade extends AbstractBusinessFacade<Biblioteca, BibliotecaDto, Integer> {

    private static final long serialVersionUID = 1L;
    
    @PostConstruct
    public void init() {
        this.mapper = IBibliotecaMapper.INSTANCE;
    }
    
}
