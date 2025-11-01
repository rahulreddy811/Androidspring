package com.example.demo.service;

import com.example.demo.model.reviewmodel;
import com.example.demo.repository.reviewrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    reviewrepository reviewrepo;

    public List<reviewmodel> getbymovie(String moviename){
        return reviewrepo.findAllByMoviename(moviename);
    }

    public reviewmodel savereview(reviewmodel review){
        return reviewrepo.save(review);
    }
}
