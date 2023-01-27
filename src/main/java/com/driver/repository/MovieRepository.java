package com.driver.repository;

import com.driver.Director;
import com.driver.Movie;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class MovieRepository {
    Map<String, Movie> movies = new HashMap<>();
    Map<String, Director> directors = new HashMap<>();
    Map<String, List<String>> pairs = new HashMap<>();

    public void save(Movie movie) {
        movies.put(movie.getName(),movie);
    }

    public void save(Director director) {
        directors.put(director.getName(),director);
    }

    public void save(String movie, String director) {
        if(movies.containsKey(movie) && directors.containsKey(director)){
            List<String> currentMovies = new ArrayList<>();
            if(pairs.containsKey(director)){
                currentMovies = pairs.get(director);
                currentMovies.add(movie);
                pairs.put(director,currentMovies);
            }
        }
    }

    public Movie getMovieByName(String movie) {
        return movies.get(movie);
    }

    public Director getDirectorByName(String director) {
        return directors.get(director);
    }
    public List<String> getMoviesByDirectorName(String director) {
        List<String> moviesList = new ArrayList<>();
        if(pairs.containsKey(director)){
            moviesList = pairs.get(director);
        }
        return moviesList;
    }

    public List<Movie> getAllMovies() {
        List<Movie> allMovies = new ArrayList<>();
        for(Movie movie : movies.values()){
            allMovies.add(movie);
        }
        return allMovies;
    }

    public void deleteDirectorMovieByName(String director) {

        List<String> moviesList = new ArrayList<>();
        if(pairs.containsKey(director)){
            moviesList = pairs.get(director);
            for (String movie : moviesList){
                if(movies.containsKey(movie)){
                    movies.remove(movie);
                }
            }
            pairs.remove(director);
        }
        if(pairs.containsKey(director)){
            pairs.remove(director);
        }

    }

    public void deleteAllDirectorsAndMovies() {
        HashSet<String> moviesSet = new HashSet<>();
        for (String director : pairs.keySet()){
            for (String movie:pairs.get(director)){
                moviesSet.add(movie);
            }
            pairs.remove(director);
            directors.remove(director);
        }
        for (String movie:moviesSet){
            if(movies.containsKey(movie)){
                movies.remove(movie);
            }
        }
    }

}
