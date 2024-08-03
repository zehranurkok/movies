package com.zehranurkok.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    private ObjectId id;
    private String body;

    // Since Review class ObjectIds are auto generated, we cant pass an ID to the class
    // Because of that we will also generate a custom constructor that takes only the body

    public Review(String body) {
        this.body = body;
    }
}
