package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class TMDbService {

    private final String API_KEY = "5a232763725804f76d13d6b21b39df96";
    private final String TMDB_URL = "https://api.themoviedb.org/3/movie/popular?api_key=" + API_KEY;

    public List<String> getPosterUrls() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> response = restTemplate.getForObject(TMDB_URL, Map.class);

        List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");
        List<String> posterUrls = new ArrayList<>();

        for (Map<String, Object> movieData : results) {
            String posterPath = (String) movieData.get("poster_path");
            if (posterPath != null) {
                String posterUrl = "https://image.tmdb.org/t/p/w500" + posterPath;
                posterUrls.add(posterUrl);
            }
        }

        return posterUrls;
    }
}
