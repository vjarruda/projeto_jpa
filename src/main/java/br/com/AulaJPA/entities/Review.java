package br.com.AulaJPA.entities;

import javax.persistence.*;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String comment;
	private Integer rating;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Product getProduct() {
		return products;
	}

	public void setProduct(Product products) {
		this.products = products;
	}
}
