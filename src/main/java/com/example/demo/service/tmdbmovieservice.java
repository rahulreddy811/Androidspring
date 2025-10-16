package com.example.demo.service;

import com.example.demo.model.TmdbMovieModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class tmdbmovieservice {

    @Value("${tmdb.api.key}")
    private String apikey;

    public List<TmdbMovieModel>RandomMovies(){

        RestTemplate rest = new RestTemplate();

        int page = new Random().nextInt(500)+1;

        String url = "https://api.themoviedb.org/3/discover/movie?api_key=" + apikey + "&page=" + page + "&sort_by=popularity.desc&include_adult=false";

        Map<String,Object> response = rest.getForObject(url,Map.class);
        List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");


        List<TmdbMovieModel> movies = new ArrayList<>();

        for (Map<String,Object>m: results){
            String title = (String) m.get("title");
            double rating = m.get("vote_average") != null ? ((Number) m.get("vote_average")).doubleValue() : 0;
            String poster = m.get("poster_path") != null ? "https://image.tmdb.org/t/p/w500" + m.get("poster_path") : "";
            movies.add(new TmdbMovieModel(title, rating, poster));
        }

        return movies;
    }
}
