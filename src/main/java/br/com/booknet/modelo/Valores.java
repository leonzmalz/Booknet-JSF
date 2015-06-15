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
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Valores other = (Valores) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
       
        return true;
    }
	

	
}
