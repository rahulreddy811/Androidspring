package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class reviewmodel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String moviename;
    private String username;
    private String review;

    public reviewmodel() {}

    public reviewmodel(Long id, String moviename, String username, String review) {
        this.id = id;
        this.moviename = moviename;
        this.username = username;
        this.review = review;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
