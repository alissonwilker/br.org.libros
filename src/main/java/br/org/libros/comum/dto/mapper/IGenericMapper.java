package br.org.libros.comum.dto.mapper;

import java.util.List;

/**
 * Mapeador genérico de Entidade para DTO e vice-versa.
 *
 * @param <E> tipo da Entidade.
 * @param <D> tipo do DTO.
 */
public interface IGenericMapper<E, D> {
	D converterParaDto(E entidade);

	E converterParaEntidade(D dto);

	List<D> converterParaDto(List<E> entidade);

	List<E> converterParaEntidade(List<D> dto);
}
