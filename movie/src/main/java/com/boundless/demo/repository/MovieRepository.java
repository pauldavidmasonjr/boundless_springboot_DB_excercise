package com.boundless.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boundless.demo.models.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>{

}
