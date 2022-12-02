package com.galaxe.movietheatre.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.galaxe.movietheatre.entities.Movie;
import com.galaxe.movietheatre.enums.MovieStatus;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{
	public Movie findByMovieName(String name);
	public List<Movie> findByMovieStatus(MovieStatus status);
}
