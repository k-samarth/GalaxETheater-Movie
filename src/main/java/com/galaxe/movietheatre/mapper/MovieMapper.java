package com.galaxe.movietheatre.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.Mapping;

import com.galaxe.movietheatre.dto.MovieDto;
import com.galaxe.movietheatre.dto.UserDto;
import com.galaxe.movietheatre.entities.Movie;
import com.galaxe.movietheatre.entities.User;

@Mapper
public interface MovieMapper {
	@Mapping(target = "movieCode", source = "movieDto.movieCode")
	@Mapping(target = "movieUrl", source = "movieDto.movieUrl")
	@Mapping(target = "movieName", source = "movieDto.movieName")
	@Mapping(target = "movieGenre", source = "movieDto.movieGenre")
	@Mapping(target = "releaseDate", source = "movieDto.releaseDate")
	@Mapping(target = "duration", source = "movieDto.duration")
	@Mapping(target = "movieStatus", source = "movieDto.movieStatus")
	@Mapping(target = "cast", source = "movieDto.cast")
	@Mapping(target = "rating", source = "movieDto.rating")
	@Mapping(target = "language", source = "movieDto.language")
	public Movie convertToEntity(MovieDto movieDto);

	@Mapping(target = "movieCode", source = "movie.movieCode")
	@Mapping(target = "movieUrl", source = "movie.movieUrl")
	@Mapping(target = "movieName", source = "movie.movieName")
	@Mapping(target = "movieGenre", source = "movie.movieGenre")
	@Mapping(target = "releaseDate", source = "movie.releaseDate")
	@Mapping(target = "duration", source = "movie.duration")
	@Mapping(target = "movieStatus", source = "movie.movieStatus")
	@Mapping(target = "cast", source = "movie.cast")
	@Mapping(target = "rating", source = "movie.rating")
	@Mapping(target = "language", source = "movie.language")
	public MovieDto convertToDto(Movie movie);
}
