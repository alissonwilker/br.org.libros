package br.org.libros.cliente.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.org.libros.cliente.dto.ClienteDto;
import br.org.libros.cliente.model.persistence.entity.Cliente;
import br.org.libros.comum.dto.mapper.IGenericMapper;

/**
 * 
 * @see br.org.libros.comum.dto.mapper.IGenericMapper
 */
@Mapper
public interface IClienteMapper extends IGenericMapper<Cliente, ClienteDto> {
	IClienteMapper INSTANCE = Mappers.getMapper(IClienteMapper.class);

}
