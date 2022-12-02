package com.galaxe.movietheatre.service;

import java.util.List;

import com.galaxe.movietheatre.dto.MovieDto;
import com.galaxe.movietheatre.entities.Cast;
import com.galaxe.movietheatre.entities.Movie;
import com.galaxe.movietheatre.exception.MovieAlreadyDeletedException;
import com.galaxe.movietheatre.exception.MovieAlreadyExistsException;
import com.galaxe.movietheatre.exception.MovieDoesNotExistsException;

public interface MovieService {
	public String saveMovie(MovieDto movieDto) throws MovieAlreadyExistsException;
	//public String movieAlreadyExists(String name);
	public String updateMovie(MovieDto movieDto) throws MovieDoesNotExistsException;
	public String deleteMovie(String moviename);// throws MovieDoesNotExistsException, MovieAlreadyDeletedException;
	public List<MovieDto> getMovies() throws MovieDoesNotExistsException;
	public MovieDto getMovieByName(String movieName) throws MovieDoesNotExistsException, MovieAlreadyDeletedException;
	public List<MovieDto> getMoviesByStatus(String status) throws MovieDoesNotExistsException;
	public Cast getMoviesByCast(String castName);
}
