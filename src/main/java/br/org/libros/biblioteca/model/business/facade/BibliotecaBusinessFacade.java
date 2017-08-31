package br.org.libros.biblioteca.model.business.facade;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.org.libros.biblioteca.dto.BibliotecaDto;
import br.org.libros.biblioteca.dto.mapper.IBibliotecaMapper;
import br.org.libros.biblioteca.model.persistente.entity.Biblioteca;
import br.org.libros.comum.exception.EntidadeJaExisteExcecao;
import br.org.libros.comum.exception.EntidadeNaoEncontradaExcecao;
import br.org.libros.comum.model.business.IBusiness;
import br.org.libros.comum.model.business.facade.AbstractBusinessFacade;

/**
 * 
 * @see br.org.libros.comum.model.business.facade.AbstractBusinessFacade
 */
@Named
@RequestScoped
@Transactional
public class BibliotecaBusinessFacade extends AbstractBusinessFacade<Biblioteca, BibliotecaDto, Integer> {

	private static final long serialVersionUID = 1L;

	@Inject
	private IBusiness<Biblioteca, Integer> business;

	protected IBibliotecaMapper mapper = IBibliotecaMapper.INSTANCE;

	@Override
	public BibliotecaDto adicionar(BibliotecaDto dto) throws EntidadeJaExisteExcecao {
		return mapper.converterBibliotecaParaBibliotecaDto(
				business.adicionar(mapper.converterBibliotecaDtoParaBiblioteca(dto)));
	}

	@Override
	public List<BibliotecaDto> listar() {
		return mapper.converterBibliotecasParaBibliotecasDto(business.listar());
	}

	@Override
	public void remover(BibliotecaDto dto) throws EntidadeNaoEncontradaExcecao {
		business.remover(mapper.converterBibliotecaDtoParaBiblioteca(dto));
	}

	@Override
	public BibliotecaDto atualizar(BibliotecaDto dto) throws EntidadeNaoEncontradaExcecao, EntidadeJaExisteExcecao {
		return mapper.converterBibliotecaParaBibliotecaDto(
				business.atualizar(mapper.converterBibliotecaDtoParaBiblioteca(dto)));
	}

	@Override
	public BibliotecaDto recuperar(Integer chavePrimaria) throws EntidadeNaoEncontradaExcecao {
		return mapper.converterBibliotecaParaBibliotecaDto(business.recuperar(chavePrimaria));
	}

	@Override
	public void remover(Integer chavePrimaria) throws EntidadeNaoEncontradaExcecao {
		business.remover(chavePrimaria);
	}

	@Override
	public BibliotecaDto atualizar(Integer chavePrimaria, BibliotecaDto dto)
			throws EntidadeNaoEncontradaExcecao, EntidadeJaExisteExcecao {
		return mapper.converterBibliotecaParaBibliotecaDto(
				business.atualizar(chavePrimaria, mapper.converterBibliotecaDtoParaBiblioteca(dto)));
	}

}
