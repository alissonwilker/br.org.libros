package br.org.libros.livrobiblioteca.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.org.libros.biblioteca.dto.LivroBibliotecaDto;
import br.org.libros.biblioteca.model.persistence.entity.LivroBiblioteca;
import br.org.libros.comum.dto.mapper.IGenericMapper;

/**
 * 
 * @see br.org.libros.comum.dto.mapper.IGenericMapper
 */
@Mapper
public interface ILivroBibliotecaMapper extends IGenericMapper<LivroBiblioteca, LivroBibliotecaDto> {
	ILivroBibliotecaMapper INSTANCE = Mappers.getMapper(ILivroBibliotecaMapper.class);

}
