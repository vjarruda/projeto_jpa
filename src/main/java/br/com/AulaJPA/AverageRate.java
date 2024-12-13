package br.com.AulaJPA;

import javax.persistence.*;

@Entity
public class AverageRate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public Review getReview() {return review;}

    public void setReview(Review review) {this.review = review;}
}
