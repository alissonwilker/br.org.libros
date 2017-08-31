package br.org.libros.biblioteca.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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

	 @Mapping(target = "bibliotecas", ignore = true)
	 LivroDto converterParaDto(Livro entidade);
	
	 @InheritInverseConfiguration
	 @Mapping(target = "bibliotecas", ignore = true)
	 Livro converterParaEntidade(LivroDto dto);
	
	 List<LivroDto> converterParaDtos(List<Livro> entidades);
	
	 @InheritInverseConfiguration
	 List<Livro> converterParaEntidades(List<LivroDto> dtos);

}
