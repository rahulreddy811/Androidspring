package com.example.demo.controller;

import com.example.demo.model.reviewmodel;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/review")
public class reviewcontroller {

    @Autowired
    private ReviewService review;

    @GetMapping("/moviereview")
    public ResponseEntity<reviewmodel> getbymoviename(@PathVariable String moviename){

        Optional<reviewmodel> moviereview = review.getbymovie(moviename);

        if (moviereview.isPresent()){
            return ResponseEntity.ok(moviereview.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public reviewmodel savereview(@RequestBody reviewmodel revmode){
        return review.savereview(revmode);
    }
}
