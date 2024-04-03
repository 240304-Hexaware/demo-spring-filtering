package com.revature.demospringfiltering.beans;

import com.revature.demospringfiltering.entities.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyRepository extends MongoRepository<Movie, ObjectId> {
    List<Movie> findMoviesByYear(String year);
}
