package com.movielist.movielist;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MoviesRepository extends CrudRepository<Movie, Long>
{
	@Query("SELECT m FROM Movie m WHERE m.moviename = :moviename")
	List<Movie> findByMoviename(@Param("moviename") String moviename);

	@Query("SELECT m FROM Movie m WHERE m.director = :director")
	List<Movie> findByDirector(@Param("director") String director);

	@Query("SELECT m FROM Movie m WHERE m.dateofrelease = :dateofrelease")
	List<Movie> findByDateofrelease(@Param("dateofrelease") String dateofrelease);

	@Query("SELECT m FROM Movie m WHERE m.director = :director AND m.dateofrelease BETWEEN :startYear AND :endYear")
	List<Movie> findByDirectorAndReleaseYearRange(@Param("director") String director, @Param("startYear") int startYear, @Param("endYear") int endYear);

}
