package com.movielist.web;

import com.movielist.movielist.User;
import com.movielist.movielist.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


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

}
