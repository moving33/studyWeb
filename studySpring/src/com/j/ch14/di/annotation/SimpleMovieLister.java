package com.j.ch14.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;


@Component("simpleMovie")
public class SimpleMovieLister {

    private MovieFinder movieFinder;

    @Autowired
    @Qualifier("movieFinder2")
    public void setMovieFinder(MovieFinder movieFinder){
        this.movieFinder = movieFinder;
    }

    public MovieFinder getMovieFinder() {
        return movieFinder;
    }
}
