package com.example.demo.service;

import com.example.demo.model.reviewmodel;
import com.example.demo.repository.reviewrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    reviewrepository reviewrepo;

    public Optional<reviewmodel> getbymovie(String moviename){
        return reviewrepo.findyMoviename(moviename);
    }

    public reviewmodel savereview(reviewmodel review){
        return reviewrepo.save(review);
    }
}
