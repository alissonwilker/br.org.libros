package br.org.libros.biblioteca.model.persistence.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.biblioteca.model.persistente.entity.Livro;
import br.org.libros.comum.excecao.EntidadeNaoEncontradaExcecao;

/**
 * 
 * @see br.org.libros.biblioteca.model.persistence.dao.BibliotecaAbstractDao
 */
@Named("LivroBibliotecaDao")
@RequestScoped
public class LivroDao extends BibliotecaAbstractDao<Livro, Integer> {
	private static final long serialVersionUID = 1L;

	@Override
	public void remover(Livro entidade) throws EntidadeNaoEncontradaExcecao {
		entityManager.createNativeQuery("delete from BIBLIOTECA_LIVRO where LIVROS_ID = :id")
				.setParameter("id", entidade.getId()).executeUpdate();
		entityManager.flush();
		super.remover(entidade);
	}

}
