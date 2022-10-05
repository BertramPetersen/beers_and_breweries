package com.example.beers_and_breweries.repository;

import com.example.beers_and_breweries.model.Beer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface BeerRepository extends MongoRepository<Beer, String> {
    @Query("{'name': ?0}")
    Optional<Beer> findByName(String name);

}
