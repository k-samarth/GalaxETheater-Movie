package com.galaxe.movietheatre.service.impl;

import java.util.ArrayList;
//import org.apache.log4j.Logger;
import java.util.List;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.galaxe.movietheatre.dto.MovieDto;
import com.galaxe.movietheatre.entities.Cast;
import com.galaxe.movietheatre.entities.Movie;
import com.galaxe.movietheatre.entities.User;
import com.galaxe.movietheatre.enums.MovieStatus;
import com.galaxe.movietheatre.exception.MovieAlreadyDeletedException;
import com.galaxe.movietheatre.exception.MovieAlreadyExistsException;
import com.galaxe.movietheatre.exception.MovieDoesNotExistsException;
import com.galaxe.movietheatre.mapper.MovieMapper;
import com.galaxe.movietheatre.repository.CastRepository;
import com.galaxe.movietheatre.repository.MovieRepository;
import com.galaxe.movietheatre.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	MovieMapper movieMapper;
	@Autowired
	CastRepository castRepository;
	//private static  Logger logg =Logger.getLogger(MovieServiceImpl.class);

	public String saveMovie(MovieDto movieDto) throws MovieAlreadyExistsException {
		//logg.info("Movie added successfully");
			Movie movie = movieRepository.findByMovieName(movieDto.getMovieName());
			if(movie!=null)
				throw new MovieAlreadyExistsException("Movie Already Exists With Given Name :"+movieDto.getMovieName());
			movie=movieMapper.convertToEntity(movieDto);
			List<Cast> setCast=movie.getCast();
			for(int i=0;i<setCast.size();i++) {
				Cast cast=castRepository.findByFirstName(setCast.get(i).getFirstName());
				if(cast!=null) {
					setCast.set(i, cast);
				}
			}
			movie.setCast(setCast);
			movieRepository.save(movie);	
			return "Movie Added SuccessFully";
	}
	
	
	public String updateMovie(MovieDto movieDto) throws MovieDoesNotExistsException {
		// TODO Auto-generated method stub
		
		Movie movie = movieRepository.findByMovieName(movieDto.getMovieName());
		if(movie==null)
			throw new MovieDoesNotExistsException("No Movie Exists With Given Name :"+movieDto.getMovieName());
			int id=movie.getMovieId(); //storing id for future purpose.
			movie=movieMapper.convertToEntity(movieDto);
			System.out.println(movie);
			List<Cast> setCast=movie.getCast();
			System.out.println(setCast);
			System.out.println(movie);
			for(int i=0;i<setCast.size();i++) {
				Cast cast=castRepository.findByFirstName(setCast.get(i).getFirstName());
				if(cast!=null){
					setCast.set(i, cast);
				}
			}
			movie.setCast(setCast);
			//Do i need set everything again??
			movie.setMovieId(id);
			movieRepository.save(movie);
		return "Movie Updated SuccessFully";
	}
	
	public String deleteMovie(String moviename) {   //throws MovieDoesNotExistsException, MovieAlreadyDeletedException
		// TODO Auto-generated method stub
		
		Movie movie=movieRepository.findByMovieName(moviename);
		if(movie==null)
			throw new MovieDoesNotExistsException("No Movie Exists With Name :"+moviename);
		if(movie.getMovieStatus()==MovieStatus.DELETE)
			throw new MovieAlreadyDeletedException("Movie Is Already Deleted With Given Name:"+moviename);
		movie.setMovieStatus(MovieStatus.DELETE);
		movieRepository.save(movie);
		return "Movie Deleted SuccessFully";
	}
	
	public List<MovieDto> getMovies() throws MovieDoesNotExistsException {
		List<Movie> allMovieList=movieRepository.findByMovieStatus(MovieStatus.RUNNING);
		allMovieList.addAll(movieRepository.findByMovieStatus(MovieStatus.UPCOMING));
		if(allMovieList.isEmpty())
			throw new MovieDoesNotExistsException("Sorry! No Movies Available.");
		List<MovieDto> allMovieDtoList=new ArrayList<MovieDto>();
		for(Movie movie:allMovieList)
			allMovieDtoList.add(movieMapper.convertToDto(movie));
		return allMovieDtoList;
	}
	
	public MovieDto getMovieByName(String movieName){
		Movie movie=movieRepository.findByMovieName(movieName);
		if(movie==null)
			throw new MovieDoesNotExistsException("No Such Movie Exists With Given Name :"+movieName);
		if(movie.getMovieStatus()==MovieStatus.DELETE)
			throw new MovieAlreadyDeletedException("Sorry! Movie Not Available.");
		MovieDto movieByName=movieMapper.convertToDto(movie);
		return movieByName;
	}
	
	public List<MovieDto> getMoviesByStatus(String status) throws MovieDoesNotExistsException {
		// TODO Auto-generated method stub
		List<Movie> movieList=movieRepository.findByMovieStatus(MovieStatus.valueOf(status));
		if(movieList.isEmpty())
			throw new MovieDoesNotExistsException("Sorry! No "+status+" Movies Available.");
		List<MovieDto> movieDtoList = new ArrayList<MovieDto>();
		for(int i=0;i<movieList.size();i++){
			movieDtoList.add(i, movieMapper.convertToDto(movieList.get(i)));
			
		}
		return movieDtoList;
		
	}
	public Cast getMoviesByCast(String castName) {
		/**
		 * 
		 * 
		 * sdfs
		 * 
		 * df
		 * dsfsdd
		 */
		
		return castRepository.findByFirstName(castName);
	}
}
