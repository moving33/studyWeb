package ch06.action;

import ch06.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRankAction {
    private List<Movie> listMovie;

    public String execute()throws Exception{
        listMovie = new ArrayList<Movie>();
        listMovie.add(new Movie("Action-01","God Of Hammer",2));
        listMovie.add(new Movie("Action-02","Guardian of Galaxy",5));
        listMovie.add(new Movie("Romance-01","About of Time",3));
        listMovie.add(new Movie("Thriller-01","Dark Knight",1));
        listMovie.add(new Movie("Horror","곤지암",4));

        return "success";
    }

    public List<Movie> getListMovie() {
        return listMovie;
    }

    public void setListMovie(List<Movie> listMovie) {
        this.listMovie = listMovie;
    }
}
