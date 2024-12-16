package br.com.AulaJPA.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class AverageRate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "averageRate", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public List<Review> getReviews() {return reviews;}

    public void setReviews(List<Review> reviews) {this.reviews = reviews;}
}
