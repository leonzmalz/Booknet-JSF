package br.com.booknet.util;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.booknet.modelo.Genero;
import br.com.booknet.modelo.Livro;
import br.com.booknet.repositorio.RepositorioDeGeneros;
import br.com.booknet.repositorio.RepositorioDeLivros;

public class TestaJPA {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		for(Livro livro : new RepositorioDeLivros().todos()){
			System.out.println(livro);
			System.out.println(livro.getGenero().getNome());
		}
			
		
		manager.close();
	}

}
