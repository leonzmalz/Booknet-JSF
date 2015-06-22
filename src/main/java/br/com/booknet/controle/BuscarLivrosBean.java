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

import org.primefaces.context.RequestContext;
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
	private Livro livroSelecionado;

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

	public Livro getLivroSelecionado() {
		return livroSelecionado;
	}

	public void carregarLivrosPorNome() {
		System.out.println(this.nomeLivro);
		this.listaDeLivros = livros.todosComNome(this.nomeLivro);

	}

	public BigDecimal pegarValor(Long id) {
		return valores.getValorVenda(id);
	}

	public String pegarValorConvertido(Long id) {
		return valores.getValorVendaConvertido(id);

	}

	public void selecionarLivro(Livro l) {
		this.livroSelecionado = l;
		RequestContext.getCurrentInstance().execute("PF('modalLivro').show();");
	}

	public boolean disponivelCompra(Long id) {
		Valores val = valores.buscar(id);
		if (val != null)
			if (val.getQuantidade() > 0)
				if (val.getValorVenda() != null)
					return true;

		return false;

	}

	public String valorBotaoCompra(Long id) {
		return disponivelCompra(id) ? "Comprar" : "Indisponível";

	}

}
