package br.org.libros.comum.exception;

public abstract class Excecao extends Exception {

	private static final long serialVersionUID = 1L;

	private Throwable causaRaiz;
	
	public Excecao() {
	}
	
	public Excecao(Throwable eeex) {
		this.causaRaiz = eeex;
	}

	public Throwable getCausaRaiz() {
		return causaRaiz;
	}
}
