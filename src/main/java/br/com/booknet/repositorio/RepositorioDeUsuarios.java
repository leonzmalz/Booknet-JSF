package br.com.booknet.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.booknet.modelo.Genero;
import br.com.booknet.modelo.Usuario;
import br.com.booknet.util.JPAUtil;

public class RepositorioDeUsuarios {

	private EntityManager manager = new JPAUtil().getEntityManager();

	public Usuario buscar(Long id) {
		
		return manager.find(Usuario.class, id);
//		Query query = manager.createQuery("from Usuario WHERE user = :user",
//				Usuario.class);
//		query.setParameter("user", user);
//
//		if (!query.getResultList().isEmpty())
//			return (Usuario) query.getResultList().get(0);
//
//		return null;

	}

}
