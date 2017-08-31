package br.org.libros.biblioteca.model.persistente.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import br.org.libros.comum.model.persistence.entity.IEntidade;

/**
 * Entidade que representa um Livro.
 *
 */
@Entity
@Table(name = "Livro", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Livro implements IEntidade {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", nullable = false, unique = true, length = 10)
	@NotNull
	@Max(Integer.MAX_VALUE)
	private int id;
	
	@ManyToMany(mappedBy = "livros")
	private List<Biblioteca> bibliotecas;

	@Valid
	public Livro() {
	}

	public int getId() {
		return id;
	}

	public void setId(@NotNull @Max(Integer.MAX_VALUE) int id) {
		this.id = id;
	}

	public List<Biblioteca> getBibliotecas() {
		return bibliotecas;
	}

	public void setBibliotecas(List<Biblioteca> bibliotecas) {
		this.bibliotecas = bibliotecas;
	}

}