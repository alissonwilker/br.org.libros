package br.org.libros.comum.model.persistence.entity.listener;

import java.io.Serializable;

/**
 * Classe que representa um evento de ciclo de vida de entidade.
 *
 */
public class EventoEntidade implements Serializable {
	private static final long serialVersionUID = 1L;
	private String payload;

	public EventoEntidade() {
	}

	public EventoEntidade(String payload) {
		setPayload(payload);
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

}
