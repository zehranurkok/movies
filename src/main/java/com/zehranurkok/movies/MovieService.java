package com.zehranurkok.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


// This class will not extend anything, just need to annotate as a service
@Service
public class MovieService {

    // This will let the framework know that we want the framework to instantiate MovieRepository class here for us
    @Autowired
    // We will need a reference of the repository
    private MovieRepository movieRepository;

    // Inside this class, we will write the db access methods
    public List<Movie> allMovies() {
        // This will find all methods is described inside the MongoRepository class
        return movieRepository.findAll();
    }

    // We will have to let Java know that it may return null
    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
