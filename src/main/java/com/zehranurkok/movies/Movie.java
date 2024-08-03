package com.zehranurkok.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

// This will let the framework note that this class sheet presents each document in the movies collection
@Document(collection = "movies")

// This will take care all of different getter, setter and toString methods
@Data

// This is an addition for creating a constructor that takes all private field as argument
@AllArgsConstructor

// This  will generate a constructor with no parameters
@NoArgsConstructor
public class Movie {
    // We can annotate this ID field as an actual ID, this will the framework know
    // that this property should be treated as the unique identifier for each movie inside the db
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;

    // This will cause only the database to store the IDs of the review. And reviews will be in a separate collection
    // Manual reference relationship
    @DocumentReference
    private List<Review> reviewIds;
}
