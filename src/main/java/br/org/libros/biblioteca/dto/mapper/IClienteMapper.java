package br.org.libros.biblioteca.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.org.libros.biblioteca.dto.ClienteDto;
import br.org.libros.biblioteca.model.persistente.entity.Cliente;
import br.org.libros.comum.dto.mapper.IGenericMapper;

/**
 * 
 * @see br.org.libros.comum.dto.mapper.IGenericMapper
 */
@Mapper
public interface IClienteMapper extends IGenericMapper<Cliente, ClienteDto> {
	IClienteMapper INSTANCE = Mappers.getMapper(IClienteMapper.class);

}
