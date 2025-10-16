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


    private tmdbmovieservice tmbdservice;

    @GetMapping("/Random")
    public List<TmdbMovieModel> getmovies(){
        return tmbdservice.RandomMovies();
    }
}
