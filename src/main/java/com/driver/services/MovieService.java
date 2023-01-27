package com.driver.services;

import com.driver.Director;
import com.driver.Movie;
import com.driver.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    public void save(Director director) {
        movieRepository.save(director);
    }

    public void save(String movie, String director) {
        movieRepository.save(movie,director);
    }
    public Movie getMovieByName(String movie) {
        return movieRepository.getMovieByName(movie);
    }

    public Director getDirectorByName(String director) {
        return movieRepository.getDirectorByName(director);
    }

    public List<String> getMoviesByDirectorName(String director) {
        return movieRepository.getMoviesByDirectorName(director);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    public void deleteDirectorMovieByName(String movie) {
        movieRepository.deleteDirectorMovieByName(movie);
    }

    public void deleteAllDirectorsAndMovies() {
        movieRepository.deleteAllDirectorsAndMovies();
    }


}
