package com.movielist.web;

import com.movielist.movielist.Movie;
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
    
	// GET a user by ID
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
    }

    @PutMapping("/users/create")
    public User createUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return repository.findById(id).map(user -> {
            user.setFirstname(updatedUser.getFirstname());
            user.setLastname(updatedUser.getLastname());
            return repository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
