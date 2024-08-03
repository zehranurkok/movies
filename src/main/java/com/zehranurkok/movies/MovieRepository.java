package com.zehranurkok.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// The Framework will know this is a repository
@Repository

// The repository layer is like a data access layer for our API.
// It does the job of actually talking to the db and getting the data back
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    // For searching with imdbID we can implement the method (Automatic Queries)
    Optional<Movie> findMovieByImdbId(String imdbId);
}
