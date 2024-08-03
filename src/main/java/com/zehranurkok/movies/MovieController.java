package com.zehranurkok.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

// Annotate this class as a Rest Controller
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    // This will let the framework know that we want the framework to instantiate MovieService class here for us
    @Autowired
    // We will need a reference to our service class
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK) ;
    }

    @GetMapping("/{imdbId}")
    // PathVariable lets the framework know that we will be passing the information we got in the mapping as a path variable
    // Or we will be using the information passed in the PathVariable as a ObjectID
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
}
