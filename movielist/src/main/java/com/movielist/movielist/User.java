package com.movielist.movielist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userid;

	private String firstname;
	private String lastname;

//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "User")
//	private List<Movies> movies;

	public User() { super(); }

	public User(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
//
//	public List<Movies> getMovies() {
//		return movies;
//	}
//
//	public void setMovies(List<Movies> movies) {
//		this.movies = movies;
//	}
}