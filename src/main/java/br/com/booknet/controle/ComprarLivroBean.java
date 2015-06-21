package br.com.booknet.controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.booknet.modelo.Livro;
import br.com.booknet.modelo.Negociacao;
import br.com.booknet.modelo.Usuario;
import br.com.booknet.repositorio.RepositorioDeLivros;

@ManagedBean
@ViewScoped
public class ComprarLivroBean {
	private Negociacao negociacao;
	private RepositorioDeLivros livros;

	public ComprarLivroBean() {
		// TODO Auto-generated constructor stub
		this.livros = new RepositorioDeLivros();
		this.negociacao = new Negociacao();
	}

	public Negociacao getNegociacao() {
		return negociacao;
	}
	
	public void setNegociacao(Negociacao negociacao) {
		this.negociacao = negociacao;
	}
	public void carregarLivro() {
		this.negociacao.setLivro(livros.buscaPorId(this.negociacao.getLivro()
				.getId()));
	}
	
	

}
