package com.zehranurkok.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    // We have to associate one of the movies because of that we create a template
    // Repositories as one of the ways to talk with dbs and Templates are other one
    // We can use this template to form up a new dynamic query and do the job inside the db without using the repository
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {
        // We will have to insert review object to the db
        Review review = reviewRepository.insert(new Review(reviewBody)); // calling insert returns the data that we just pushed inside our db

        // Using the template to perform an update call on the Movie class because each movie contains an empty array of reviewIds
        mongoTemplate.update(Movie.class)
                // Updating a movie where imdbId of the movie in the db matches the imdbId that we received from the user
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
