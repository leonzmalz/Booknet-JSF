package br.com.booknet.controle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.StreamedContent;

import br.com.booknet.modelo.Livro;
import br.com.booknet.modelo.Valores;
import br.com.booknet.repositorio.RepositorioDeLivros;
import br.com.booknet.repositorio.RepositorioDeValores;

@ManagedBean
@ViewScoped
public class BuscarLivrosBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nomeLivro;
	private List<Livro> listaDeLivros;
	private RepositorioDeLivros livros;
	private RepositorioDeValores valores;
	
	public BuscarLivrosBean() {
		this.livros = new RepositorioDeLivros();
		this.valores = new RepositorioDeValores();
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
	
	public String getValor(Long id){
		System.out.println(id);
		Valores valorBanco = valores.buscar(id);
		if(valorBanco != null){
			Locale brasil = new Locale("pt","BR");
			DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (brasil));
			df.setParseBigDecimal (true);  
			String valorConvertido = df.format(valorBanco.getValorVenda());
			
			return "R$ " + valorConvertido;
		}	
		return null;
	}
	
	
    
	

}
