package com.galaxe.movietheatre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.galaxe.movietheatre.mapper.MovieMapper;
import com.galaxe.movietheatre.mapper.MovieMapperImpl;
import com.galaxe.movietheatre.mapper.ScheduleMapper;
import com.galaxe.movietheatre.mapper.ScheduleMapperImpl;
import com.galaxe.movietheatre.mapper.UserMapper;
import com.galaxe.movietheatre.mapper.UserMapperImpl;

@SpringBootApplication
public class GalaxeMovieTheatreApplication {

	public static void main(String[] args) {
		SpringApplication.run(GalaxeMovieTheatreApplication.class, args);
	}
	
	@Bean
	public UserMapper getUserMapper() {
		return new UserMapperImpl();
	}
	 
	@Bean
	public MovieMapper getMovieMapper() {
		return new MovieMapperImpl();
	}
	@Bean
	public ScheduleMapper getScheduleMapper() {
		return new ScheduleMapperImpl();
	}
}
