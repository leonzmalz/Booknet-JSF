package br.com.booknet.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "livros_valores")
public class Valores implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="idLivroValores")
	private Long id;
	@Column(nullable = true)
	private int quantidade;
	@Column(nullable = true, precision = 10, scale = 2)
	private BigDecimal valorVenda;
	@Column(nullable = true, precision = 10, scale = 2)
	private BigDecimal valorAluguel;
	@Column(nullable = true, precision = 5, scale = 3)
	private BigDecimal taxaRenovacao;
	@Column(nullable = true, precision = 5, scale = 3)
	private BigDecimal multa;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}
	public BigDecimal getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(BigDecimal valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	public BigDecimal getTaxaRenovacao() {
		return taxaRenovacao;
	}
	public void setTaxaRenovacao(BigDecimal taxaRenovacao) {
		this.taxaRenovacao = taxaRenovacao;
	}
	public BigDecimal getMulta() {
		return multa;
	}
	public void setMulta(BigDecimal multa) {
		this.multa = multa;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Valores other = (Valores) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
