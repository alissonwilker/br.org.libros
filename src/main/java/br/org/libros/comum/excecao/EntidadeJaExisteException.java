package br.org.libros.comum.excecao;

import javax.persistence.PersistenceException;

/**
 * Classe que representa uma exceção de Entidade que já existe. Normalmente
 * lançada quando uma Entidade que já existe está tentando ser cadastrada
 * novamente.
 *
 * @see br.org.libros.comum.excecao.LibrosException
 */
public class EntidadeJaExisteException extends LibrosException {

	private static final long serialVersionUID = 1L;

	public EntidadeJaExisteException(PersistenceException eeex) {
		super(eeex);
	}

}
