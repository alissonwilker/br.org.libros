package br.org.libros;

import java.io.File;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public abstract class AbstractIntegrationTest {
	protected static final String TEST_APP_CONTEXT_ROOT = "libros";

	@Deployment
	public static Archive<?> criarDeploymentTeste() {
		WebArchive deploymentTeste = ShrinkWrap.create(WebArchive.class, TEST_APP_CONTEXT_ROOT + ".war");

		deploymentTeste.merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class)
				.importDirectory("src/main/webapp").as(GenericArchive.class), "/", Filters.includeAll());

		File[] bibliotecas = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeAndTestDependencies().resolve()
				.withTransitivity().asFile();
		deploymentTeste.addAsLibraries(bibliotecas).addPackages(true, "br.org.libros");

		deploymentTeste.merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class)
				.importDirectory("src/main/resources").as(GenericArchive.class), "/WEB-INF/classes",
				Filters.includeAll());

		return deploymentTeste;
	}

}
