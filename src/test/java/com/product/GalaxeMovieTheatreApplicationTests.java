package com.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.galaxe.movietheatre.dto.MovieDto;
import com.galaxe.movietheatre.entities.Cast;
import com.galaxe.movietheatre.entities.Movie;
import com.galaxe.movietheatre.enums.Code;
import com.galaxe.movietheatre.enums.Language;
import com.galaxe.movietheatre.enums.MovieStatus;
import com.galaxe.movietheatre.exception.MovieAlreadyDeletedException;
import com.galaxe.movietheatre.exception.MovieAlreadyExistsException;
import com.galaxe.movietheatre.exception.MovieDoesNotExistsException;
import com.galaxe.movietheatre.repository.MovieRepository;
import com.galaxe.movietheatre.service.MovieService;
import com.galaxe.movietheatre.service.impl.MovieServiceImpl;

@SpringBootTest(classes=GalaxeMovieTheatreApplicationTests.class)
class GalaxeMovieTheatreApplicationTests {
	@MockBean
	MovieRepository movieRepository;
	@Autowired(required=false)
	MovieServiceImpl movieService;
//	@Test
//	void testsaveMovie() {
//		List<Movie> movies=new ArrayList<>();
//		Movie movie1=new Movie(1, Code.A, "huhjde", "ABCD", "Drama", LocalDate.parse("2022-12-05"), "150mins",MovieStatus.RUNNING, "yhuifwjek",Language.English , null);
//		when(movieRepository.findByMovieName(movie1.getMovieName())).thenReturn(movie1);
//		movie1.setMovieStatus(MovieStatus.DELETE);
//		assertEquals(MovieStatus.DELETE, movie1.getMovieStatus());
//}
	
	@Test
	void testbyName() {
		Movie movie1=new Movie(1, Code.A, "huhjde", "amazing spiderman", "Drama", LocalDate.parse("2022-12-05"), "150mins",MovieStatus.RUNNING, "yhuifwjek",Language.English , null);
		when(movieRepository.findByMovieName(movie1.getMovieName())).thenReturn(movie1);
		System.out.println(movie1);
		System.out.println(movieService.getMovieByName("amazing spiderman")+"hi");
		
		assertEquals(movieService.getMovieByName("amazing spiderman"),movie1.getMovieName());
	}
}
