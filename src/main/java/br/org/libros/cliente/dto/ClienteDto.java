package br.org.libros.cliente.dto;

import java.io.Serializable;

public class ClienteDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String cpf;

	private String nome;

	public ClienteDto() {
	}

	public ClienteDto(String cpfCliente, String nomeCliente) {
		setCpf(cpfCliente);
		setNome(nomeCliente);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
