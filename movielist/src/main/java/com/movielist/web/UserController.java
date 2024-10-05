package com.movielist.web;

import com.movielist.movielist.User;
import com.movielist.movielist.UserRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController
{
    private final UserRepository repository;

    public UserController(UserRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/users")
    public Iterable<User> getUsers()
    {
        return repository.findAll();
    }
    
    
	// GET a movie by ID
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Movie not found with ID: " + id));
    }

}
