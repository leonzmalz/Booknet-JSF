package br.com.booknet.modelo;



import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "livros_valores")
public class Valores implements Serializable,SampleEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idLivroValores")
	private Long id;
	@Column(nullable = true)
	private int quantidade;
	@Column(nullable = true, precision = 10, scale = 2)
	private BigDecimal valorVenda;
	@Column(nullable = true, precision = 10, scale = 2)
	private BigDecimal valorAluguel;
	@Column(nullable = true, precision = 5, scale = 2)
	private BigDecimal taxaRenovacao;
	@Column(nullable = true, precision = 5, scale = 2)
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
		result = prime * result + ((multa == null) ? 0 : multa.hashCode());
		result = prime * result + quantidade;
		result = prime * result
				+ ((taxaRenovacao == null) ? 0 : taxaRenovacao.hashCode());
		result = prime * result
				+ ((valorAluguel == null) ? 0 : valorAluguel.hashCode());
		result = prime * result
				+ ((valorVenda == null) ? 0 : valorVenda.hashCode());
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
		if (multa == null) {
			if (other.multa != null)
				return false;
		} else if (!multa.equals(other.multa))
			return false;
		if (quantidade != other.quantidade)
			return false;
		if (taxaRenovacao == null) {
			if (other.taxaRenovacao != null)
				return false;
		} else if (!taxaRenovacao.equals(other.taxaRenovacao))
			return false;
		if (valorAluguel == null) {
			if (other.valorAluguel != null)
				return false;
		} else if (!valorAluguel.equals(other.valorAluguel))
			return false;
		if (valorVenda == null) {
			if (other.valorVenda != null)
				return false;
		} else if (!valorVenda.equals(other.valorVenda))
			return false;
		return true;
	}
	
	
	@Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return Long.toString(this.id);
    }
    
    public void clear(){
		this.multa = null;
		this.quantidade = 0;
		this.taxaRenovacao = null;
		this.valorAluguel = null;
		this.valorVenda = null;
	}
	

	
}
