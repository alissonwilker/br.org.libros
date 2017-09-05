package br.org.libros.biblioteca.model.business;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.org.libros.biblioteca.model.persistente.entity.LivroBiblioteca;
import br.org.libros.comum.excecao.LibrosRuntimeException;
import br.org.libros.comum.model.business.AbstractBusiness;

/**
 * 
 * @see br.org.libros.comum.model.business.AbstractBusiness
 */
@Named
@RequestScoped
public class LivroBibliotecaBusiness extends AbstractBusiness<LivroBiblioteca, Integer> {

	private static final long serialVersionUID = 1L;

	@Override
	public List<LivroBiblioteca> listar() {
		// TODO substituir endereço hardcoded por um service discovery
		Client client = ClientBuilder.newClient();
		JsonArray jsonArrayResponse = client.target("http://localhost:8080/libros/api/livros/")
				.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
		ObjectMapper jsonToObjectMapper = new ObjectMapper();
		List<LivroBiblioteca> livrosBibliotecas = null;
		try {
			livrosBibliotecas = jsonToObjectMapper.readValue(jsonArrayResponse.toString(),
					new TypeReference<List<LivroBiblioteca>>() {
					});
		} catch (IOException e) {
			throw new LibrosRuntimeException(e);
		}
		return livrosBibliotecas;
	}

}
