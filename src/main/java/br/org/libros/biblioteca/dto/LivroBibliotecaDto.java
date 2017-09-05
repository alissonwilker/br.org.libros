package br.org.libros.biblioteca.dto;

import br.org.libros.comum.dto.IDto;

/**
 * DTO que representa a Entidade
 * {@link br.org.libros.biblioteca.model.persistente.entity.Livro Livro}.
 *
 */
public class LivroDto implements IDto {

	private static final long serialVersionUID = 1L;

	private int id;

	public LivroDto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
