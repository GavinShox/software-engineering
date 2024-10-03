package com.movielist.movielist;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//^^ don't think all of these are needed but i'm getting errors


@Entity
public class Movies {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Movieid;
	private String moviename, director, dateofrelease;

	
	public Movies() {
		super();
	}
	
	
	public Movies(String moviename, String director, String dateofrelease) {
	super();
		this.moviename = moviename;
		this.director = director;
		this.dateofrelease = dateofrelease;
	}
	

	public Long getMovieid() {
		return Movieid;
	}


	public void setMovieid(Long movieid) {
		Movieid = movieid;
	}


	public String getMoviename() {
		return moviename;
	}


	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getDateofrelease() {
		return dateofrelease;
	}


	public void setDateofrelease(String dateofrelease) {
		this.dateofrelease = dateofrelease;
	}
	
}
