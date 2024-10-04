package com.movielist.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movielist.movielist.Movie;
import com.movielist.movielist.MoviesRepository;

@RestController
public class MoviesController {

	private final MoviesRepository repository;

	public MoviesController(MoviesRepository repository)
	{
		this.repository = repository;
	}

	@GetMapping("/movies")
	public Iterable<Movie> getMovie()
	{
		return repository.findAll();
	}
	
}
