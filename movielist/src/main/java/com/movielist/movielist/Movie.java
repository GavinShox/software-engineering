package com.movielist.movielist;

import jakarta.persistence.*;
//^^ don't think all of these are needed but i'm getting errors


@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Movieid;
	private String moviename, director, dateofrelease;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users")
	private User user;
	
	public Movie() {
		super();
	}
	
	
	public Movie(String moviename, String director, String dateofrelease, User user) {
	super();
		this.moviename = moviename;
		this.director = director;
		this.dateofrelease = dateofrelease;
		this.user = user;
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
