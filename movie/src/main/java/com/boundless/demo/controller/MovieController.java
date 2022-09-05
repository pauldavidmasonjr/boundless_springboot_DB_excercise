package com.boundless.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.boundless.demo.beans.MovieWrapper;
import com.boundless.demo.service.MovieService;



@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@PostMapping("/saveMovie")
	public ResponseEntity<MovieWrapper> saveStudent(@RequestBody MovieWrapper movieWrapper) {
		movieWrapper = movieService.saveMovie(movieWrapper);
		return ResponseEntity.ok(movieWrapper);
	}
	
	@GetMapping("/getMovie/{id}")
	public ResponseEntity<MovieWrapper> getMovieById(@PathVariable Long id) {
		
		MovieWrapper movieWrapper = movieService.getMovieById(id);
		
		return ResponseEntity.ok(movieWrapper);
	}
	
	@DeleteMapping("/deleteMovie/{id}")
	public ResponseEntity<Object> deleteMovie(@PathVariable Long id) {
		movieService.deleteMovie(id);
		return ResponseEntity.noContent().build();
	}
	
}
