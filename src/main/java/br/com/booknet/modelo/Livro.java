package br.com.booknet.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="idLivro")
	private Long id;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(nullable = true, length = 45)
	private String permiteAluguel;
	@Column(nullable = true, length = 200)
	private String foto;
	@Column(name = "ISBN", nullable = true, length = 45)
	private String isbn;
	@Column(nullable = true, length = 50)
	private String editora;
	@Column(nullable = true, length = 100)
	private String autor;
	@Column(nullable = true, length = 45)
	private String nacionalidade;
	@ManyToOne
	@JoinColumn(name = "idGenero", nullable = false)
	private Genero genero;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPermiteAluguel() {
		return permiteAluguel;
	}

	public void setPermiteAluguel(String permiteAluguel) {
		this.permiteAluguel = permiteAluguel;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	public Genero getGenero() {
		return genero;
	}
	
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

    @Override
	public String toString() {
		return "id=" + id + ", nome=" + nome;
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
        final Livro other = (Livro) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
	
}
