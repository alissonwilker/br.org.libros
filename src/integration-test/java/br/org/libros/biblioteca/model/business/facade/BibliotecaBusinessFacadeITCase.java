package br.org.libros.biblioteca.model.business.facade;

import java.io.File;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.org.libros.biblioteca.dto.BibliotecaDto;
import br.org.libros.comum.exception.EntidadeJaExisteExcecao;

/**
 * Classe de teste que testa o comportamento da fachada negocial do módulo
 * Biblioteca.
 *
 */
@RunWith(Arquillian.class)
public class BibliotecaBusinessFacadeITCase {
	@Inject
	private BibliotecaBusinessFacade bibliotecaBusinessFacade;

	@Deployment
	public static Archive<?> criarArquivoTeste() {
		Archive<?> arquivoTeste = ShrinkWrap.create(WebArchive.class, "librosTesteIntegracao.war")
				.addPackages(true, "br.org.libros").addAsResource("META-INF/persistence.xml").addAsLibrary(new File(
						"target/libros/WEB-INF/lib/mapstruct-jdk8-1.1.0.Final.jar"));

		return arquivoTeste;
	}

	/**
	 * Test method for
	 * {@link br.org.libros.comum.model.business.facade.AbstractBusinessFacade#adicionar(java.lang.Object)}.
	 */
	@Test
	public void testAdicionar() {
        Assert.fail(" dsfsdf");
		BibliotecaDto bibliotecaDto = new BibliotecaDto("nome1");
		BibliotecaDto bibliotecaDtoResposta;
		try {
			bibliotecaDtoResposta = this.bibliotecaBusinessFacade.adicionar(bibliotecaDto);
			Assert.assertEquals(bibliotecaDto.getNome(), bibliotecaDtoResposta.getNome());
			Assert.assertNotNull(bibliotecaDtoResposta.getId());
		} catch (EntidadeJaExisteExcecao e) {
			Assert.fail("Entidade já existe.");
		}
	}

}
