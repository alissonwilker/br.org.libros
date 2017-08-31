package br.org.libros.biblioteca.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.org.libros.biblioteca.dto.BibliotecaDto;
import br.org.libros.biblioteca.dto.LivroDto;
import br.org.libros.biblioteca.model.persistente.entity.Biblioteca;
import br.org.libros.biblioteca.model.persistente.entity.Livro;

/**
 * 
 * @see br.org.libros.comum.dto.mapper.IGenericMapper
 */
@Mapper
public interface IBibliotecaMapper {
	IBibliotecaMapper INSTANCE = Mappers.getMapper(IBibliotecaMapper.class);

	BibliotecaDto converterBibliotecaParaBibliotecaDto(Biblioteca entidade);

	Biblioteca converterBibliotecaDtoParaBiblioteca(BibliotecaDto dto);

	List<BibliotecaDto> converterBibliotecasParaBibliotecasDto(List<Biblioteca> entidades);

	List<Biblioteca> converterBibliotecasDtoParaBibliotecas(List<BibliotecaDto> dtos);

	@Mapping(target = "bibliotecas", ignore = true)
	LivroDto converterLivroParaLivroDto(Livro entidade);

	@Mapping(target = "bibliotecas", ignore = true)
	Livro converterLivroDtoParaLivro(LivroDto dto);

	List<LivroDto> converterLivrosParaLivrosDto(List<Livro> entidades);

	List<Livro> converterLivrosDtoParaLivros(List<LivroDto> dtos);
}
