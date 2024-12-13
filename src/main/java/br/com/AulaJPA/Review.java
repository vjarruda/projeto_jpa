package br.com.AulaJPA;

import javax.persistence.*;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer nota;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	//getters e setters
	public Long getId() {return id;}

	public void setId(Long id) {this.id = id;}

	public Integer getNota() {return nota;}

	public void setNota(Integer nota) {this.nota = nota;}

	public Product getProduct() {return product;}

	public void setProduct(Product product) {this.product = product;}
	
}
