package br.org.libros.biblioteca.dto;

import java.io.Serializable;
import java.util.List;

/**
 * DTO que representa a Entidade
 * {@link br.org.libros.biblioteca.model.persistente.entity.Livro Livro}.
 *
 */
public class LivroDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private List<BibliotecaDto> bibliotecas;

	public LivroDto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<BibliotecaDto> getBibliotecas() {
		return bibliotecas;
	}

	public void setBibliotecas(List<BibliotecaDto> bibliotecas) {
		this.bibliotecas = bibliotecas;
	}


}
