package com.boundless.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boundless.demo.beans.MovieWrapper;
import com.boundless.demo.models.Movie;
import com.boundless.demo.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	//SAVE
	public MovieWrapper saveMovie(MovieWrapper inputMovie) {
		
		Movie movie = new Movie();
		
		//movie.setId(inputMovie.getId());
		movie.setName(inputMovie.getName());
		movie.setGenre(inputMovie.getGenre());
		
		movie = repository.save(movie);
		
		inputMovie.setId(movie.getId());
		inputMovie.setName(movie.getName());
		
		return inputMovie;
	}
	
	//Get Movie by ID
	public MovieWrapper getMovieById(Long Id) {
		
		MovieWrapper movieWrapper = null;
		
		Optional<Movie> movieOptionalData = repository.findById(Id);
		
		if(movieOptionalData.isPresent()) {
			movieWrapper = new MovieWrapper();
			Movie movie = movieOptionalData.get();
			movieWrapper.setId(movie.getId());
			movieWrapper.setName(movie.getName());
			movieWrapper.setGenre(movie.getGenre());
		}
		return movieWrapper;
	}
	
	//DELETE
	public void deleteMovie(long movieId) {
		
		Optional<Movie> movieOptionalData = repository.findById(movieId);
		
		if(movieOptionalData.isPresent()) {
			Movie movie = movieOptionalData.get();
			repository.delete(movie);
		}
	}
	
	
}
