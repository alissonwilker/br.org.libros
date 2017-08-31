package br.org.libros.biblioteca.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.org.libros.biblioteca.dto.BibliotecaDto;
import br.org.libros.biblioteca.dto.LivroDto;
import br.org.libros.biblioteca.model.persistente.entity.Biblioteca;
import br.org.libros.biblioteca.model.persistente.entity.Livro;
import br.org.libros.comum.dto.mapper.IGenericMapper;

/**
 * 
 * @see br.org.libros.comum.dto.mapper.IGenericMapper
 */
@Mapper
public interface IBibliotecaMapper extends IGenericMapper<Biblioteca, BibliotecaDto> {
	IBibliotecaMapper INSTANCE = Mappers.getMapper(IBibliotecaMapper.class);

	LivroDto converterLivroParaLivroDto(Livro entidade);

	Livro converterLivroDtoParaLivro(LivroDto dto);

	List<LivroDto> converterLivroParaLivroDto(List<Livro> entidades);

	List<Livro> converterLivroDtoParaLivro(List<LivroDto> dtos);
}
