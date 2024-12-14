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

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Review> reviews;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "type_id", referencedColumnName = "id")
	private Type type;

	
	//getters e setters
	public long getId() { return id; }

	public void setId(long id) {this.id = id;}

	public String getNome() {return nome;}

	public void setNome(String nome) {this.nome = nome;}

	public String getDescricao() {return descricao;}

	public void setDescricao(String descricao) {this.descricao = descricao;}

	public Double getPreco() {return preco;}

	public void setPreco(Double preco) {this.preco = preco;}

	public List<Review> getReviews() {return reviews;}

	public void setReviews(List<Review> reviews) {this.reviews = reviews;}

	public List<Comment> getComments() {return comments;}

	public void setComments(List<Comment> comments) {this.comments = comments;}

	public Type getType() {return type;}

	public void setType(Type type) {this.type = type;}
	
	

}
