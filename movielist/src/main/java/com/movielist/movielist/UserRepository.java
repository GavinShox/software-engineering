package com.movielist.movielist;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.firstname = :firstname")
	List<User> findByFirstname(@Param("firstname") String firstname);

	@Query("SELECT u FROM User u WHERE u.lastname = :lastname")
	List<User> findByLastname(@Param("lastname") String lastname);

	@Query("SELECT u FROM User u WHERE u.firstname LIKE %:name% OR u.lastname LIKE %:name% ORDER BY u.id")
	List<User> findByNameContaining(@Param("name") String name);


}
