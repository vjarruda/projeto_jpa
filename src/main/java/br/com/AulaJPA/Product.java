package br.com.AulaJPA;

import java.util.List;

import javax.persistence.*;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;
	private String descricao;
	private Double preco;
	private String tipo;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Review> reviews;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Comment> comments;

	
	//getters e setters
	public long getId() { return id; }

	public void setId(long id) {this.id = id;}

	public String getNome() {return nome;}

	public void setNome(String nome) {this.nome = nome;}

	public String getDescricao() {return descricao;}

	public void setDescricao(String descricao) {this.descricao = descricao;}

	public Double getPreco() {return preco;}

	public void setPreco(Double preco) {this.preco = preco;}

	public String getTipo() {return tipo;}

	public void setTipo(String tipo) {this.tipo = tipo;}

	public List<Review> getReviews() {return reviews;}

	public void setReviews(List<Review> reviews) {this.reviews = reviews;}

	public List<Comment> getComments() {return comments;}

	public void setComments(List<Comment> comments) {this.comments = comments;}

}
