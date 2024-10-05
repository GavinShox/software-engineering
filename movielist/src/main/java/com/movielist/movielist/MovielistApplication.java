package com.movielist.movielist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class MovielistApplication implements CommandLineRunner {
	
	private final MoviesRepository repository;
	private final UserRepository userRepository;
	private static final Logger logger = LoggerFactory.getLogger(MovielistApplication.class);
	
	public MovielistApplication(MoviesRepository repository, UserRepository userRepository) {
		this.repository = repository;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MovielistApplication.class, args);
		
		System.out.println("Test");
		logger.info("Application started");
		
	}
	
	@Override
	public void run(String... args) throws Exception{

		User user1 = new User("John", "Smith");
		User user2 = new User("Jane", "Doe");
		User user3 = new User("John", "Smith");
		User user4 = new User("John", "Smith");

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		
		repository.save(new Movie("Inception", "Christopher Nolan", "2010-07-16", user1));
		repository.save(new Movie("The Matrix", "Lana Wachowski, Lilly Wachowski", "1999-03-31", user2));
		repository.save(new Movie("The Godfather", "Francis Ford Coppola", "1972-03-24", user3));
		repository.save(new Movie("Jurassic Park", "Steven Spielberg", "1993-06-11", user1));
		 
		 //Fetch all movies and log to console
		 for (Movie movies : repository.findAll()) {
			 
			 logger.info("Title: {}, Director: {}, Release Date: {}", movies.getMoviename(), movies.getDirector(), movies.getDateofrelease());
		 }

		 for (User user : userRepository.findAll()) {
			 logger.info("First name: {}, Last name: {}", user.getFirstname(), user.getLastname());
		 }
	}

}
