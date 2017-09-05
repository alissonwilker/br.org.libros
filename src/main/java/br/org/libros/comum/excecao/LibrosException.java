package br.org.libros.comum.excecao;

/**
 * Classe abstrata que representa uma exceção genérica do sistema. 
 *
 * @see java.lang.Exception
 */
public abstract class LibrosException extends Exception {

	private static final long serialVersionUID = 1L;

	private Throwable causaRaiz;
	
	public LibrosException() {
	}
	
	public LibrosException(Throwable eeex) {
		this.causaRaiz = eeex;
	}

	public Throwable getCausaRaiz() {
		return causaRaiz;
	}
}
