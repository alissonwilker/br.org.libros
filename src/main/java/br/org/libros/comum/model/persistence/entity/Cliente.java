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

import br.org.libros.comum.model.persistence.entity.validator.annotation.Cpf;

@Entity
@Table(name = "Cliente", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true, length = 10)
	@NotNull
	@Max(Integer.MAX_VALUE)
	private int id;

	@Column(name = "CPF", nullable = false, unique = true, length = 11)
	@NotNull
	@Cpf
	private String cpf;

	@Column(name = "NOME", nullable = false, unique = false, length = 20)
	@NotNull
	@Size(max = 20)
	private String nome;

	@ManyToMany
	@JoinTable(name = "Cliente_Livro", joinColumns = @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "LIVRO_ID", referencedColumnName = "ID"))
	private List<Livro> livros = new ArrayList<Livro>();

	@Valid
	public Cliente() {
	}

	@Valid
	public Cliente(String cpf, String nome) {
		setCpf(cpf);
		setNome(nome);
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public int getId() {
		return id;
	}

	public void setId(@NotNull @Max(Integer.MAX_VALUE) int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(@NotNull @Cpf String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(@NotNull @Size(max = 20) String nome) {
		this.nome = nome;
	}

}