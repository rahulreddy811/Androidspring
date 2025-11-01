package com.example.demo.controller;

import com.example.demo.model.reviewmodel;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/review")
public class reviewcontroller {

    @Autowired
    private ReviewService review;

    @GetMapping("/moviereview/{moviename}")
    public ResponseEntity<List<reviewmodel>> getbymoviename(@PathVariable String moviename){

        List<reviewmodel> moviereview = review.getbymovie(moviename);

        if (moviereview.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(moviereview);
        }
    }

    @PostMapping("/save")
    public reviewmodel savereview(@RequestBody reviewmodel revmode){
        return review.savereview(revmode);
    }
}
