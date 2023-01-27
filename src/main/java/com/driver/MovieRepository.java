package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {
    private Map<String, Movie> movies;
    private Map<String, Director> directors;
    private Map<String, List<String>> pairs;

    public MovieRepository() {
        this.movies = new HashMap<>();
        this.directors = new HashMap<>();
        this.pairs = new HashMap<>();
    }

    public void save(Movie movie) {
        movies.put(movie.getName(), movie);
    }

    public void save(Director director) {
        directors.put(director.getName(), director);
    }

    public void save(String movie, String director) {
        if (movies.containsKey(movie) && directors.containsKey(director)) {
            List<String> currentMovies = pairs.getOrDefault(director, new ArrayList<>());
            currentMovies.add(movie);
            pairs.put(director, currentMovies);
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
        if (pairs.containsKey(director)) {
            moviesList = pairs.get(director);
        }
        return moviesList;
    }

    public List<String> getAllMovies() {
        List<String> allMovies = new ArrayList<>();
        for (String movie : movies.keySet()) {
            allMovies.add(movie);
        }
        return allMovies;
    }

    public void deleteDirectorMovieByName(String director) {

        List<String> moviesList = new ArrayList<>();
        if (pairs.containsKey(director)) {
            moviesList = pairs.get(director);
            for (String movie : moviesList) {
                if (movies.containsKey(movie)) {
                    movies.remove(movie);
                }
            }
            pairs.remove(director);
        }
        if (pairs.containsKey(director)) {
            pairs.remove(director);
        }

    }

    public void deleteAllDirectorsAndMovies() {
        HashSet<String> moviesSet = new HashSet<>();
        for (String director : pairs.keySet()) {
            for (String movie : pairs.get(director)) {
                moviesSet.add(movie);
            }
            pairs.remove(director);
            directors.remove(director);
        }
        for (String movie : moviesSet) {
            if (movies.containsKey(movie)) {
                movies.remove(movie);
            }
        }
    }

}
