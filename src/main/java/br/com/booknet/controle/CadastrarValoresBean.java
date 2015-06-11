package br.com.booknet.controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.booknet.modelo.Livro;
import br.com.booknet.modelo.Valores;
import br.com.booknet.repositorio.RepositorioDeGeneros;
import br.com.booknet.repositorio.RepositorioDeLivros;

@ManagedBean
@ViewScoped
public class CadastrarValoresBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Valores valores;
	private List<Livro> listaDeLivros;
	private RepositorioDeLivros livros;

	public CadastrarValoresBean() {
		// TODO Auto-generated constructor stub
		this.valores = new Valores();
		this.livros = new RepositorioDeLivros();
	}

	public void inicializar() {
		this.listaDeLivros = livros.todos();
	}

	public Valores getValores() {
		return valores;
	}

	public void setValores(Valores valores) {
		this.valores = valores;
	}

	public List<Livro> getListaDeLivros() {
		return listaDeLivros;
	}

	public void setListaDeLivros(List<Livro> listaDeLivros) {
		this.listaDeLivros = listaDeLivros;
	}

	public void salvar() {
		/*produtos.guardar(produto, categoria);

		this.produto = new Produto();

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Produto " + operacao + " com sucesso")); */

	}

}
