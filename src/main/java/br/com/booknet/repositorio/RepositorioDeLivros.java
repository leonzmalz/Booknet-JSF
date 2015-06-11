package br.com.booknet.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.booknet.modelo.Livro;
import br.com.booknet.util.JPAUtil;

public class RepositorioDeLivros implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private EntityManager manager = new JPAUtil().getEntityManager();
	
	public List<Livro> todos() {
		return manager.createQuery("from Livro", 
                Livro.class).getResultList();
		
	}

}
