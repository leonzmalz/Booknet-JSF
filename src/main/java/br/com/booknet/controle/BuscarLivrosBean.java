package br.com.booknet.controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.StreamedContent;

import br.com.booknet.modelo.Livro;
import br.com.booknet.repositorio.RepositorioDeLivros;

@ManagedBean
@ViewScoped
public class BuscarLivrosBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nomeLivro;
	private List<Livro> listaDeLivros;
	private RepositorioDeLivros livros;
	
	public BuscarLivrosBean() {
		this.livros = new RepositorioDeLivros();
	}
	
	public String getNomeLivro() {
		return nomeLivro;
	}
	
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	
	public List<Livro> getListaDeLivros() {
		return listaDeLivros;
	}
	
	public void setListaDeLivros(List<Livro> listaDeLivros) {
		this.listaDeLivros = listaDeLivros;
	}
	
	public void carregarLivrosPorNome(){
		System.out.println(this.nomeLivro);
		this.listaDeLivros = livros.todosComNome(this.nomeLivro);
		
	}
	
    
	

}
