package br.org.libros.biblioteca.dto;

import java.util.List;

import br.org.libros.comum.dto.IDto;

/**
 * DTO que representa a Entidade
 * {@link br.org.libros.biblioteca.model.persistente.entity.Biblioteca
 * Biblioteca}.
 *
 */
public class BibliotecaDto implements IDto {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private List<LivroDto> livros;

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

	public List<LivroDto> getLivros() {
		return livros;
	}

	public void setLivros(List<LivroDto> livros) {
		this.livros = livros;
	}

}
