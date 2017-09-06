package br.org.arquitetura.excecao;

import javax.persistence.PersistenceException;

/**
 * Classe que representa uma exceção de Entidade que já existe. Normalmente
 * lançada quando uma Entidade que já existe está tentando ser cadastrada
 * novamente.
 *
 * @see br.org.arquitetura.excecao.Excecao
 */
public class EntidadeJaExisteExcecao extends Excecao {

	private static final long serialVersionUID = 1L;

	public EntidadeJaExisteExcecao(PersistenceException eeex) {
		super(eeex);
	}

}
