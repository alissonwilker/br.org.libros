package br.org.libros.biblioteca.model.business;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.org.libros.biblioteca.model.persistente.entity.Biblioteca;
import br.org.libros.biblioteca.model.persistente.entity.Livro;
import br.org.libros.comum.exception.EntidadeJaExisteExcecao;
import br.org.libros.comum.exception.EntidadeNaoEncontradaExcecao;
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
	public Biblioteca atualizar(Integer pk, Biblioteca entidade) throws EntidadeJaExisteExcecao, EntidadeNaoEncontradaExcecao {
			Client client = ClientBuilder.newClient();
			if (entidade.getLivros() != null) {
				for (Livro livro : entidade.getLivros()) {
					Response response = client.target("http://localhost:8080/libros/api/livros/" + livro.getId()).request(MediaType.APPLICATION_JSON).get();
					if (Status.fromStatusCode(response.getStatus()) != Status.OK) {
						throw new EntidadeNaoEncontradaExcecao();
					}
				}
			}
			return super.atualizar(pk, entidade);
	}
}
