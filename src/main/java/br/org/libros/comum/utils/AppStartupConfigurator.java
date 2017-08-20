package br.org.libros.comum.utils;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.org.libros.comum.exception.EntidadeJaExisteExcecao;
import br.org.libros.usuario.dto.UsuarioDto;
import br.org.libros.usuario.model.business.facade.UsuarioBusinessFacade;

@Singleton
@Startup
public class AppStartupConfigurator {
	private Logger logger = LoggerFactory.getLogger(AppStartupConfigurator.class);

	@Inject
	private UsuarioBusinessFacade usuarioBusinessFacade;

	@PostConstruct
	public void configureAppAtStartup() {
		try {
			usuarioBusinessFacade
					.adicionar(new UsuarioDto("admin", "21232f297a57a5a743894a0e4a801fc3", "ADMINISTRATOR"));
			usuarioBusinessFacade.adicionar(new UsuarioDto("user", "ee11cbb19052e40b07aac0ca060c23ee", "USER"));
		} catch (EntidadeJaExisteExcecao e) {
			logger.error(e.getMessage(), e);
		}
	}

}
