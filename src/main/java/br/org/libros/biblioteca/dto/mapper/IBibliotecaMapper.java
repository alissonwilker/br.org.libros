package br.org.libros.biblioteca.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.org.libros.biblioteca.dto.BibliotecaDto;
import br.org.libros.comum.dto.mapper.IGenericMapper;
import br.org.libros.comum.model.persistence.entity.Biblioteca;

/**
 * 
 * @see br.org.libros.comum.dto.mapper.IGenericMapper
 */
@Mapper
public interface IBibliotecaMapper extends IGenericMapper<Biblioteca, BibliotecaDto> {
	IBibliotecaMapper INSTANCE = Mappers.getMapper(IBibliotecaMapper.class);

}
