package ru.arhat.wetblue.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by etovladislav on 21.06.16.
 */

@Entity
public class ReviewCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Review> review;

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

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }
}
