package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

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

    public List<String> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    public void deleteDirectorMovieByName(String director) {
        movieRepository.deleteDirectorMovieByName(director);
    }

    public void deleteAllDirectorsAndMovies() {
        movieRepository.deleteAllDirectorsAndMovies();
    }


}
