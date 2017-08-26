package br.org.libros.biblioteca.model.business.facade;

import static org.junit.Assert.fail;

import java.io.File;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
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
		File[] files = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve()
				.withTransitivity().asFile();

		Archive<?> arquivoTeste = ShrinkWrap.create(WebArchive.class, "librosTesteIntegracao.war")
				.addPackages(true, "br.org.libros").addAsResource("META-INF/persistence.xml")
				.addAsLibraries(files);

		return arquivoTeste;
	}

	/**
	 * Test method for
	 * {@link br.org.libros.comum.model.business.facade.AbstractBusinessFacade#adicionar(java.lang.Object)}.
	 */
	@Test
	public void testAdicionar() {
		BibliotecaDto bibliotecaDto = new BibliotecaDto("nome1");
		BibliotecaDto bibliotecaDtoResposta;
		try {
			bibliotecaDtoResposta = bibliotecaBusinessFacade.adicionar(bibliotecaDto);
			Assert.assertEquals(bibliotecaDto.getNome(), bibliotecaDtoResposta.getNome());
			Assert.assertNotNull(bibliotecaDtoResposta.getId());
		} catch (EntidadeJaExisteExcecao e) {
			fail("Entidade já existe.");
		}
	}

}
