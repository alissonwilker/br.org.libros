package br.org.libros.biblioteca.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.org.libros.biblioteca.dto.LivroBibliotecaDto;
import br.org.libros.biblioteca.model.persistente.entity.LivroBiblioteca;
import br.org.libros.comum.dto.mapper.IGenericMapper;

/**
 * 
 * @see br.org.libros.comum.dto.mapper.IGenericMapper
 */
@Mapper
public interface ILivroBibliotecaMapper extends IGenericMapper<LivroBiblioteca, LivroBibliotecaDto> {
	ILivroBibliotecaMapper INSTANCE = Mappers.getMapper(ILivroBibliotecaMapper.class);

	LivroBibliotecaDto converterParaDto(LivroBiblioteca entidade);

	LivroBiblioteca converterParaEntidade(LivroBibliotecaDto dto);

	List<LivroBibliotecaDto> converterParaDtos(List<LivroBiblioteca> entidades);

	List<LivroBiblioteca> converterParaEntidades(List<LivroBibliotecaDto> dtos);

}
