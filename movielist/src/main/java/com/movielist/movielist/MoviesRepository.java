package com.movielist.movielist;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MoviesRepository extends CrudRepository<Movie, Long>
{
	List<Movie> findByMoviename(String moviename);
	
	List<Movie> findByDirector(String director);
	
	List<Movie> findByDateofrelease(String moviename);

}
