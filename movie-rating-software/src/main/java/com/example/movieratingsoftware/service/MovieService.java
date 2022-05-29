package com.example.movieratingsoftware.service;

import com.example.movieratingsoftware.model.Movie;
import com.example.movieratingsoftware.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    public List getAllMovie() {
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }
    public void updateMovie(Movie movie, String movieId) {
        Movie oldMovie=movieRepository.findById(movieId).get();

        if (movie.getDuration()!=null&&movie.getName()!=null
                &&movie.getRating()!=null&&movie.getLaunchDate()!=null){
            oldMovie.setName(movie.getName());
            oldMovie.setGenre(movie.getGenre());
            oldMovie.setRating(movie.getRating());
            oldMovie.setLaunchDate(movie.getLaunchDate());
        }
        //********************* we have to save the updated movie again to the DB ************************
        movieRepository.save(oldMovie);
    }
    public void deleteMovie(String movieId) {
        movieRepository.deleteById(movieId);
    }
}
