package br.org.libros.comum.excecao;

/**
 * Classe abstrata que representa uma exceção genérica do sistema. 
 *
 * @see java.lang.Exception
 */
public class LibrosRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Throwable causaRaiz;
	
	public LibrosRuntimeException() {
	}
	
	public LibrosRuntimeException(Throwable eeex) {
		this.causaRaiz = eeex;
	}

	public Throwable getCausaRaiz() {
		return causaRaiz;
	}
}
