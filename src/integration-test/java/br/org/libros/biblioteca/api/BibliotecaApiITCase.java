package br.org.libros.biblioteca.api;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.post;
import static org.hamcrest.Matchers.hasItems;

import org.apache.http.HttpStatus;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.org.libros.AbstractIntegrationTest;

/**
 * Classe de teste que testa o comportamento da API do módulo Biblioteca.
 *
 */
@RunWith(Arquillian.class)
public class BibliotecaApiITCase extends AbstractIntegrationTest {
	private static final String BASE_HREF = "/" + TEST_APP_CONTEXT_ROOT + "/api/bibliotecas";

	/**
	 * Test method for
	 * {@link br.org.libros.biblioteca.api.BibliotecaApi#adicionar(java.lang.String)}
	 * and {@link br.org.libros.biblioteca.api.BibliotecaApi#listar()}.
	 */
	@Test
	public void testAdicionarEListar() {
		post(BASE_HREF + "/aa").then().statusCode(HttpStatus.SC_CREATED);
		get(BASE_HREF).then().body("id", hasItems(1));
	}

}
