package br.com.booknet.repositorio;


import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.booknet.modelo.Livro;
import br.com.booknet.util.JPAUtil;

public class RepositorioDeLivros implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private EntityManager manager = new JPAUtil().getEntityManager();
	
	public List<Livro> todos() {
		return manager.createQuery("from Livro", 
                Livro.class).getResultList();
		
	}
	
	public List<Livro> todosComNome(String nome){
		 Query query = manager.createQuery("from Livro WHERE nome LIKE :pNome",Livro.class);
		 query.setParameter("pNome", "%" + nome + "%");
		 return query.getResultList();
	}
	
	public Livro buscaPorId(Long id) {
		return manager.find(Livro.class, id);
	}

}
