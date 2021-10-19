package com.example.NotflixServer.controller;

import com.example.NotflixServer.models.Movie;
import com.example.NotflixServer.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/movie/")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity getMovies() {
        Iterable<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity(movies, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getMovieById(@PathVariable String id) {
        Optional<Movie> movie = movieService.getMovieById(id);
        return new ResponseEntity(movie, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveMovie(@RequestBody Movie movie) {
        Movie createdMovie = movieService.saveMovie(movie);
        return new ResponseEntity(createdMovie, HttpStatus.OK);
    }

    @PutMapping("update/")
    public ResponseEntity updateMovie(@RequestBody Movie movie) {
        Movie updatedMovie = movieService.updateMovie(movie);
        return new ResponseEntity(updatedMovie, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteMovieById(@PathVariable String id) {
        Optional<Movie> deletedMovie = movieService.deleteMovieById(id);
        return new ResponseEntity(deletedMovie, HttpStatus.OK);
    }
}
