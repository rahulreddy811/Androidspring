package com.example.demo.service;

import com.example.demo.model.reviewmodel;
import com.example.demo.repository.reviewrepository;

import java.util.Optional;

public class ReviewService {

    reviewrepository reviewrepo;

    public Optional<reviewmodel> getbymovie(String moviename){
        return reviewrepo.findbyMoviename(moviename);
    }

    public reviewmodel savereview(reviewmodel review){
        return reviewrepo.save(review);
    }
}
