package br.com.booknet.repositorio;


import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.booknet.modelo.Genero;
import br.com.booknet.util.JPAUtil;

public class RepositorioDeGeneros implements Serializable{
	
private EntityManager manager = new JPAUtil().getEntityManager();
	
	public List<Genero> todos() {
		return manager.createQuery("from Genero", 
                Genero.class).getResultList();
		
	}

}
