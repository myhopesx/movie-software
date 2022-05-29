package com.example.movieratingsoftware.controller;


import com.example.movieratingsoftware.model.Movie;
import com.example.movieratingsoftware.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    @GetMapping
    public ResponseEntity getMovie(){
        return ResponseEntity.status(200).body(movieService.getAllMovie());
    }

    @PostMapping
    public ResponseEntity postMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("Movie Added!!");
    }
    @PutMapping("{movieid}")
    public ResponseEntity postMovie(@RequestBody Movie movie, @PathVariable String movieid){
        movieService.updateMovie(movie,movieid);
        return ResponseEntity.status(200).body("Movie Updated!!");
    }

    @DeleteMapping("{movieid}")
    public ResponseEntity deleteMovie(@PathVariable String movieid){
        movieService.deleteMovie(movieid);
        return ResponseEntity.status(200).body("Movie deleted!!");
    }
}
