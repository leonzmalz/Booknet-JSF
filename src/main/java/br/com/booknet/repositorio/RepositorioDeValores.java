package br.com.booknet.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.booknet.modelo.Livro;
import br.com.booknet.modelo.Valores;
import br.com.booknet.util.JPAUtil;

public class RepositorioDeValores {
	
	private static final long serialVersionUID = 1L;

	private EntityManager manager = new JPAUtil().getEntityManager();
	
	
	public Valores guardar(Valores valores) {
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		valores = manager.merge(valores);
		trx.commit();
		
		return valores;
	}

}
