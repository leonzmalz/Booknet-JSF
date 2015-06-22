package br.com.booknet.modelo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="negociacoes")
public class Negociacao {

	@Id
	@GeneratedValue
	@Column(name="idNegociacao")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "idLivro", nullable = false)
	private Livro livro;
	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;
	@Column(name="dataNegociacao",nullable = false)
	private Date dataNegociacao;
	@Column(nullable=true,length=20)
	private String formaPagamento;
	@Column(nullable=true)
	private int qtdParcelas;
	@Column(nullable=true,precision = 10, scale = 2)
	private BigDecimal valor;
	
	
	public Negociacao() {
		// TODO Auto-generated constructor stub
		this.livro = new Livro();
		this.usuario = new Usuario();
		this.formaPagamento = "BOLETO";
		this.dataNegociacao = new Date(System.currentTimeMillis()); //Pego a data atual
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getDataNegociacao() {
		return dataNegociacao;
	}
	public void setDataNegociacao(Date dataNegociacao) {
		this.dataNegociacao = dataNegociacao;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public int getQtdParcelas() {
		return qtdParcelas;
	}
	public void setQtdParcelas(int qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	
	
}
