package com.galaxe.movietheatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.galaxe.movietheatre.entities.Cast;

public interface CastRepository extends JpaRepository<Cast, Integer>{
	public Cast findByFirstName(String firstName);
}
