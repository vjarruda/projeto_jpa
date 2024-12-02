package br.com.AulaJPA;

import javax.persistence.*;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	//getters e setters
	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public Product getProduct() { return product; }

	public void setProduct(Product product) { this.product = product; }
	
	
}
