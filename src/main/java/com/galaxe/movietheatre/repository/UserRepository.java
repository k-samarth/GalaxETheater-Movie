package com.galaxe.movietheatre.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.galaxe.movietheatre.entities.User;

public interface UserRepository extends CrudRepository<User,Integer> {
	public Optional<User> findByEmail(String email);
}
