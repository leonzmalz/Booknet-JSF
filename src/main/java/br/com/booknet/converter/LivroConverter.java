package br.com.booknet.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.booknet.modelo.Livro;
import br.com.booknet.repositorio.RepositorioDeLivros;

@FacesConverter (forClass = Livro.class)
public class LivroConverter implements Converter {

	private RepositorioDeLivros livros = new RepositorioDeLivros();
	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		Livro retorno = null;
		
		if (value != null) {
			Long id = new Long(value);
			retorno = livros.buscaPorId(id);
		}
		
		
		return retorno; 
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		
		if (value != null) {
			Livro livro = (Livro) value;
			return livro.getId() == null ? null : livro.getId().toString();
		}
		
		return "";
		
	}
	

}
