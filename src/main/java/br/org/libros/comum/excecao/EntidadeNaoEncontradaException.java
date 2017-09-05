package br.org.libros.comum.excecao;

/**
 * Classe que representa uma exceção de Entidade não encontrada. Normalmente
 * lançada quando tenta-se realizar uma operação sobre uma Entidade que não
 * existe.
 *
 * @see br.org.libros.comum.excecao.LibrosException
 */
public class EntidadeNaoEncontradaException extends LibrosException {

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(IllegalArgumentException iaex) {
		super(iaex);
	}

	public EntidadeNaoEncontradaException() {
		super();
	}

}
