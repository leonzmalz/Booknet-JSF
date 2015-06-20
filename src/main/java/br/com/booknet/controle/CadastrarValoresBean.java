package br.com.booknet.controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.context.RequestContext;

import br.com.booknet.modelo.Livro;
import br.com.booknet.modelo.Valores;
import br.com.booknet.repositorio.RepositorioDeGeneros;
import br.com.booknet.repositorio.RepositorioDeLivros;
import br.com.booknet.repositorio.RepositorioDeValores;

@ManagedBean
@ViewScoped
public class CadastrarValoresBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Valores valor;
	private List<Livro> listaDeLivros;
	private RepositorioDeLivros livros;
	private RepositorioDeValores valores;
	private Livro livro;

	public CadastrarValoresBean() {
		// TODO Auto-generated constructor stub
		this.valor = new Valores();
		this.livros = new RepositorioDeLivros();
		this.valores = new RepositorioDeValores();
	}

	public void iniciarMascaras() {
		RequestContext.getCurrentInstance().execute("configurarMoeda();");
		RequestContext.getCurrentInstance().execute("configurarTaxas();");
	}

	public void inicializar() {
		this.listaDeLivros = livros.todos();

	}

	public Valores getValor() {
		return valor;
	}

	public void setValores(Valores valor) {
		this.valor = valor;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getListaDeLivros() {
		return listaDeLivros;
	}

	public void setListaDeLivros(List<Livro> listaDeLivros) {
		this.listaDeLivros = listaDeLivros;
	}

	public void salvar() {
		valores.guardar(this.valor);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Valores cadastrados com sucesso"));

	}

	public void buscar() {
		Valores valorBuscado = valores.buscar(this.valor.getId());
		System.out.println(valorBuscado);
		if (valorBuscado != null) {
			// this.valor = valorBuscado;
			this.valor.setMulta(valorBuscado.getMulta());
			this.valor.setQuantidade(valorBuscado.getQuantidade());
			this.valor.setTaxaRenovacao(valorBuscado.getTaxaRenovacao());
			this.valor.setValorAluguel(valorBuscado.getTaxaRenovacao());
			this.valor.setValorVenda(valorBuscado.getValorVenda());
		} else
			this.valor.clear();
	}

}
