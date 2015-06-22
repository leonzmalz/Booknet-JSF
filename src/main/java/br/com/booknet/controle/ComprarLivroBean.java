package br.com.booknet.controle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;

import org.primefaces.context.RequestContext;

import br.com.booknet.modelo.Livro;
import br.com.booknet.modelo.Negociacao;
import br.com.booknet.modelo.Usuario;
import br.com.booknet.modelo.Valores;
import br.com.booknet.repositorio.RepositorioDeLivros;
import br.com.booknet.repositorio.RepositorioDeNegociacoes;
import br.com.booknet.repositorio.RepositorioDeUsuarios;
import br.com.booknet.repositorio.RepositorioDeValores;

@ManagedBean
@ViewScoped
public class ComprarLivroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Negociacao negociacao;
	private RepositorioDeLivros livros;
	private RepositorioDeNegociacoes negociacoes;
	private RepositorioDeUsuarios usuarios;
	private String valorConvertido;
	private BigDecimal valorOriginal;
	private boolean usuarioOk = false;

	public ComprarLivroBean() {
		// TODO Auto-generated constructor stub
		this.livros = new RepositorioDeLivros();
		this.negociacao = new Negociacao();
		this.negociacoes = new RepositorioDeNegociacoes();
		this.usuarios = new RepositorioDeUsuarios();
	}

	public Negociacao getNegociacao() {
		return negociacao;
	}

	public void setNegociacao(Negociacao negociacao) {
		this.negociacao = negociacao;
	}

	public String getValorConvertido() {
		return valorConvertido;
	}

	public void setValorConvertido(String valorConvertido) {
		this.valorConvertido = valorConvertido;
	}

	public void carregarLivro() {
		this.negociacao.setLivro(livros.buscaPorId(this.negociacao.getLivro()
				.getId()));
		// Salvo o valor original para usar na divisão das parcelas
		this.valorOriginal = this.negociacao.getValor();

	}
	
	// Pego e carrego o usuário
	public void pegarCookie() {
		Map<String, Object> cookies = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestCookieMap();

		Cookie cookie = (Cookie) cookies.get("user");
		if (cookie != null) {
			this.negociacao.setUsuario(usuarios.buscar(Long.parseLong(cookie
					.getValue())));
			System.out.println("Usuário logado - " + this.negociacao.getUsuario().getUser());
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Não existe Usuário logado, por favor faça login para concluir a compra", "ERRO"));
		}

	}


	public void converterValor() {
		if (this.negociacao.getValor() != null) {
			Locale brasil = new Locale("pt", "BR");
			DecimalFormat df = new DecimalFormat("#,##0.00",
					new DecimalFormatSymbols(brasil));
			df.setParseBigDecimal(true);
			String valorConvertido = df.format(this.negociacao.getValor());

			this.setValorConvertido("R$ " + valorConvertido);
		}

	}

	public void salvar() {
		System.out.println(this.negociacao.getUsuario().getUser());
		negociacoes.guardar(this.negociacao);
		// Decremento uma unidade no estoque
		RepositorioDeValores valores = new RepositorioDeValores();
		Valores valor = valores.buscar(this.negociacao.getLivro().getId());
		valor.setQuantidade(valor.getQuantidade() - 1);
		valores.guardar(valor);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Compra efetuada"));

	}

	public boolean exibirParcelas() {
		return this.negociacao.getFormaPagamento().equals("CARTAO");
	}

	public void atualizaValorParcela() {
		BigDecimal novoValor = this.valorOriginal.divide(new BigDecimal(
				negociacao.getQtdParcelas()), 3, RoundingMode.HALF_EVEN);
		System.out.println(novoValor);
		this.negociacao.setValor(novoValor);
		this.converterValor();
	}

}
