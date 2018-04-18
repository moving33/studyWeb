package com.j.ch14.di.annotation;


public class MovieFinder {
    private String movie;

    public MovieFinder() {
        this.movie ="Infinity war of ...";
    }

    public MovieFinder(String a){
        this.movie = a;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
}
