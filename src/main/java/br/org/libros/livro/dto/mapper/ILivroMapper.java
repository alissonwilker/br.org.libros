package br.org.libros.livro.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.org.libros.comum.dto.mapper.IGenericMapper;
import br.org.libros.comum.model.persistence.entity.Livro;
import br.org.libros.livro.dto.LivroDto;

/**
 * 
 * @see br.org.libros.comum.dto.mapper.IGenericMapper
 */
@Mapper
public interface ILivroMapper extends IGenericMapper<Livro, LivroDto> {
	ILivroMapper INSTANCE = Mappers.getMapper(ILivroMapper.class);

}
