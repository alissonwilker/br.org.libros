package br.org.libros.comum.model.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entidade que representa uma Biblioteca.
 *
 */
@Entity
@Table(name = "Biblioteca", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Biblioteca implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true, length = 10)
	@NotNull
	@Max(Integer.MAX_VALUE)
	private int id;

	@Column(name = "NOME", length = 20, unique = true, nullable = false)
	@NotNull
	@Size(max = 20)
	private String nome;

	@Valid
	public Biblioteca() {
	}

	@Valid
	public Biblioteca(String nome) {
		setNome(nome);
	}

	public int getId() {
		return id;
	}

	public void setId(@NotNull @Max(999999999) int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(@NotNull @Size(max = 20) String nome) {
		this.nome = nome;
	}

}