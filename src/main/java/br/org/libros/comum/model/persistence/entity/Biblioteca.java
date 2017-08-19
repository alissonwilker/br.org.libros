package br.org.libros.comum.model.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	@ManyToMany
	@JoinTable(name = "Biblioteca_Livro", joinColumns = @JoinColumn(name = "BIBLIOTECA_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "LIVRO_ID", referencedColumnName = "ID"))
	private List<Livro> livros = new ArrayList<Livro>();

	@Valid
	public Biblioteca() {
	}

	@Valid
	public Biblioteca(String nome) {
		setNome(nome);
	}

	public List<Livro> getLivros() {
		return livros;
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