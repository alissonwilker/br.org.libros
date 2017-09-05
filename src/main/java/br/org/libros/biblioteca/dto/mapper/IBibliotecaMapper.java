package br.org.libros.biblioteca.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.org.libros.biblioteca.dto.BibliotecaDto;
import br.org.libros.biblioteca.model.persistente.entity.Biblioteca;
import br.org.libros.comum.dto.mapper.IGenericMapper;

/**
 * 
 * @see br.org.libros.comum.dto.mapper.IGenericMapper
 */
@Mapper(uses = ILivroMapper.class)
public interface IBibliotecaMapper extends IGenericMapper<Biblioteca, BibliotecaDto> {
	IBibliotecaMapper INSTANCE = Mappers.getMapper(IBibliotecaMapper.class);

}
