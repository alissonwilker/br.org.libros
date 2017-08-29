package br.org.libros.biblioteca.model.persistente.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true, length = 10)
	@NotNull
	@Max(Integer.MAX_VALUE)
	private int id;

	@ManyToOne
	@JoinColumn(name = "BIBLIOTECA_ID", nullable = false)
	@NotNull
	private Biblioteca biblioteca;

	@Valid
	public Livro() {
	}

	public int getId() {
		return id;
	}

	public void setId(@NotNull @Max(Integer.MAX_VALUE) int id) {
		this.id = id;
	}

	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(@NotNull Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

}