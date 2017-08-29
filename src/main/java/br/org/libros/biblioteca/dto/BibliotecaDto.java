package br.org.libros.biblioteca.dto;

import java.io.Serializable;

/**
 * DTO que representa a Entidade {@link br.org.libros.biblioteca.model.persistente.entity.Biblioteca Biblioteca}.
 *
 */
public class BibliotecaDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;

	public BibliotecaDto() {
	}

	public BibliotecaDto(String nomeBiblioteca) {
		setNome(nomeBiblioteca);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
