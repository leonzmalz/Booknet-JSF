package br.com.booknet.controle;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.booknet.modelo.Valores;

@ManagedBean
@SessionScoped
public class TemplatePadraoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String nomeLivro;
	
	
	public String getNomeLivro() {
		return nomeLivro;
	}
	
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	

}
