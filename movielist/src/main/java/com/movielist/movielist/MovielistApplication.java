package com.movielist.movielist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//not sure if imports are needed
import com.movielist.movielist.Movies;
import com.movielist.movielist.MoviesRepository;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class MovielistApplication implements CommandLineRunner {
	
	private final MoviesRepository repository;
	private static final Logger logger = LoggerFactory.getLogger(MovielistApplication.class);
	
	public MovielistApplication(MoviesRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MovielistApplication.class, args);
		
		System.out.println("Test");
		logger.info("Application started");
		
	}
	
	@Override
	public void run(String... args) throws Exception{
		
		 repository.save(new Movies("Inception", "Christopher Nolan", "2010-07-16"));
		 repository.save(new Movies("The Matrix", "Lana Wachowski, Lilly Wachowski", "1999-03-31"));
		 repository.save(new Movies("The Godfather", "Francis Ford Coppola", "1972-03-24"));
		 
		 //Fetch all movies and log to console
		 for (Movies movies : repository.findAll()) {
			 
			 logger.info("Title: {}, Director: {}, Release Date: {}", movies.getMoviename(), movies.getDirector(), movies.getDateofrelease());
		 }
	}

}
