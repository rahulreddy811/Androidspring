package com.example.demo.model;

public class TmdbMovieModel {

    private String MovieName;
    private Double Rating;
    private String PosterUrl;



    public TmdbMovieModel(String movieName, Double rating, String posterUrl) {
        MovieName = movieName;
        Rating = rating;
        PosterUrl = posterUrl;
    }


    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public Double getRating() {
        return Rating;
    }

    public void setRating(Double rating) {
        Rating = rating;
    }

    public String getPosterUrl() {
        return PosterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        PosterUrl = posterUrl;
    }

}
