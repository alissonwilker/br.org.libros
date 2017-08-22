package br.org.libros.comum.utils;

/**
 * Classe que verifica se um ISBN é válido.
 *
 */
public class VerificadorIsbn {
	public static boolean isValido(String isbn) {
		if (isbn == null) {
			return false;
		}

		return (isbn.length() == 13 && (isbn.startsWith("978") || isbn.startsWith("979"))
				&& calcularDigitoVerificador(isbn.substring(0, 12)).equals(isbn.substring(12, 13)));
	}

	private static String calcularDigitoVerificador(String num) {
		Integer digitoVerificador;
		int soma = 0;
		for (int i = 0; i < num.length(); i += 2) {
			soma += Integer.parseInt(num.substring(i, i + 1)) + Integer.parseInt(num.substring(i + 1, i + 2)) * 3;
		}
		digitoVerificador = (10 - soma % 10) % 10;
		return String.valueOf(digitoVerificador);
	}

}