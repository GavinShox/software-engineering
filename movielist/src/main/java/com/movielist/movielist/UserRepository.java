package com.movielist.movielist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByFirstname(String firstname);
    List<User> findByLastname(String lastname);

    //@Query("select u from users")
//    List<User> findByFirstNameStartsWith(String firstname);

}
