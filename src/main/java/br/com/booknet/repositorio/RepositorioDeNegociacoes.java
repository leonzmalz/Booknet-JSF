package br.com.booknet.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.booknet.modelo.Negociacao;
import br.com.booknet.modelo.Valores;
import br.com.booknet.util.JPAUtil;

public class RepositorioDeNegociacoes {
	private EntityManager manager = new JPAUtil().getEntityManager();
	
	public Negociacao guardar(Negociacao negociacao) {
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		negociacao = manager.merge(negociacao);
		trx.commit();
		return negociacao;
	}

}
