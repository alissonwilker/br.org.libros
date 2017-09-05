package br.org.libros.biblioteca.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.org.libros.biblioteca.dto.LivroDto;
import br.org.libros.biblioteca.model.persistente.entity.Livro;
import br.org.libros.comum.dto.mapper.IGenericMapper;

/**
 * 
 * @see br.org.libros.comum.dto.mapper.IGenericMapper
 */
@Mapper
public interface ILivroMapper extends IGenericMapper<Livro, LivroDto> {
	ILivroMapper INSTANCE = Mappers.getMapper(ILivroMapper.class);

	LivroDto converterParaDto(Livro entidade);

	Livro converterParaEntidade(LivroDto dto);

	List<LivroDto> converterParaDtos(List<Livro> entidades);

	List<Livro> converterParaEntidades(List<LivroDto> dtos);

}
