package br.com.booknet.repositorio;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.booknet.modelo.Livro;
import br.com.booknet.modelo.Valores;
import br.com.booknet.util.JPAUtil;

public class RepositorioDeValores {
	
	private static final long serialVersionUID = 1L;

	private EntityManager manager = new JPAUtil().getEntityManager();
	
	
	public Valores guardar(Valores valores) {
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		valores = manager.merge(valores);
		trx.commit();
		return valores;
	}
	
	public Valores buscar(Long id){
		return manager.find(Valores.class, id);
		
	}
	
	public BigDecimal getValorVenda(Long id) {
		Valores valorBanco = this.buscar(id);
		if (valorBanco != null) {
			return valorBanco.getValorVenda();
		}
		return null;
	}

	public String getValorVendaConvertido(Long id) {
		BigDecimal valor = this.getValorVenda(id);
		if ( valor != null) {
			Locale brasil = new Locale("pt", "BR");
			DecimalFormat df = new DecimalFormat("#,##0.00",
					new DecimalFormatSymbols(brasil));
			df.setParseBigDecimal(true);
			String valorConvertido = df.format(valor);

			return "R$ " + valorConvertido;
		}
		return null;

	}
	
	
}
