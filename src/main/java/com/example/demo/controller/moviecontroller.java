package com.example.demo.controller;

import com.example.demo.model.TmdbMovieModel;
import com.example.demo.service.tmdbmovieservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/randommovies")
public class moviecontroller {


    @Autowired
    private tmdbmovieservice tmbdservice;



    @GetMapping("/random")
    public List<TmdbMovieModel> getmovies(){
        return tmbdservice.RandomMovies();
    }
}
