package br.com.AulaJPA.entities;

import javax.persistence.*;

@Entity
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String type;
    
    @OneToOne(mappedBy = "type")
    private Product product;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

	public Product getProduct() {return product;}

	public void setProduct(Product product) {this.product = product;}
    
    
}
