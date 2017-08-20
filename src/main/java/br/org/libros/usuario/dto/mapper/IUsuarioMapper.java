package br.org.libros.usuario.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.org.libros.comum.dto.mapper.IGenericMapper;
import br.org.libros.comum.model.persistence.entity.Usuario;
import br.org.libros.usuario.dto.UsuarioDto;

/**
 * 
 * @see br.org.libros.comum.dto.mapper.IGenericMapper
 */
@Mapper
public interface IUsuarioMapper extends IGenericMapper<Usuario, UsuarioDto> {
	IUsuarioMapper INSTANCE = Mappers.getMapper(IUsuarioMapper.class);

}