package br.org.libros.biblioteca.model.business;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.org.libros.biblioteca.model.persistente.entity.Biblioteca;
import br.org.libros.biblioteca.model.persistente.entity.LivroBiblioteca;
import br.org.libros.comum.excecao.EntidadeJaExisteException;
import br.org.libros.comum.excecao.EntidadeNaoEncontradaException;
import br.org.libros.comum.model.business.AbstractBusiness;

/**
 * 
 * @see br.org.libros.comum.model.business.AbstractBusiness
 */
@Named
@RequestScoped
public class BibliotecaBusiness extends AbstractBusiness<Biblioteca, Integer> {

	private static final long serialVersionUID = 1L;

	@Override
	public Biblioteca atualizar(Biblioteca entidade) throws EntidadeJaExisteException, EntidadeNaoEncontradaException {
			verificarExistenciaLivros(entidade);
			return super.atualizar(entidade);
	}

	@Override
	public Biblioteca adicionar(Biblioteca entidade) throws EntidadeJaExisteException, EntidadeNaoEncontradaException {
			verificarExistenciaLivros(entidade);
			return super.atualizar(entidade);
	}
	
	private void verificarExistenciaLivros(Biblioteca entidade) throws EntidadeNaoEncontradaException {
		if (entidade.getLivros() != null) {
			for (LivroBiblioteca livro : entidade.getLivros()) {
				//TODO substituir endereço hardcoded por um service discovery
				Client client = ClientBuilder.newClient();
				Response response = client.target("http://localhost:8080/libros/api/livros/" + livro.getId()).request(MediaType.APPLICATION_JSON).get();
				if (Status.fromStatusCode(response.getStatus()) != Status.OK) {
					throw new EntidadeNaoEncontradaException();
				}
			}
		}
	}
	
}
