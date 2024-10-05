package com.movielist.web;

import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;



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
	
	// GET a movie by ID
    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Movie not found with ID: " + id));
    }
    
	@GetMapping("/movies/director/{director}")
	public List<Movie> getMovieByDirector(@PathVariable String director)
	{
		return repository.findByDirector(director);
		
	}
    
}
