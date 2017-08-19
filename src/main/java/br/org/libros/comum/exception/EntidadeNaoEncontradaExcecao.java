package br.org.libros.comum.exception;

/**
 * Classe que representa uma exceção de Entidade não encontrada. Normalmente
 * lançada quando tenta-se realizar uma operação sobre uma Entidade que não
 * existe.
 *
 * @see br.org.libros.comum.exception.Excecao
 */
public class EntidadeNaoEncontradaExcecao extends Excecao {

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaExcecao(IllegalArgumentException iaex) {
		super(iaex);
	}

	public EntidadeNaoEncontradaExcecao() {
		super();
	}

}
