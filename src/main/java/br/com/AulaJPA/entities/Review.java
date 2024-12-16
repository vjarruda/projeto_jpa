package br.com.AulaJPA.entities;

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

	@ManyToOne
	@JoinColumn(name = "average_rate_id")
	private AverageRate averageRate;

	// Getters e Setters
	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public Integer getNota() { return nota; }

	public void setNota(Integer nota) { this.nota = nota; }

	public Product getProduct() { return product; }

	public void setProduct(Product product) { this.product = product; }

	public AverageRate getAverageRate() { return averageRate; }

	public void setAverageRate(AverageRate averageRate) { this.averageRate = averageRate; }
}
