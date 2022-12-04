package com.galaxe.movietheatre.controller;

import java.io.IOException;
import java.util.List;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galaxe.movietheatre.dto.MovieDto;
import com.galaxe.movietheatre.entities.Cast;
import com.galaxe.movietheatre.exception.MovieAlreadyDeletedException;
import com.galaxe.movietheatre.exception.MovieAlreadyExistsException;
import com.galaxe.movietheatre.exception.MovieDoesNotExistsException;
import com.galaxe.movietheatre.service.impl.MovieServiceImpl;

@RestController
@RequestMapping("movies")
@CrossOrigin("*")
public class MovieController {
	
//		private static  Logger log =Logger.getLogger(MovieController.class);
		
		@Autowired
		MovieServiceImpl movieServiceImpl;
		
		@PostMapping("addmovie")
		public ResponseEntity<?> addMovie(@RequestBody MovieDto movieDto) {
			ResponseEntity<?> responseEntity = null;
				try {
					String message=movieServiceImpl.saveMovie(movieDto);
//					log.info(message+" With Name: "+movieDto.getMovieName());
					responseEntity=new ResponseEntity<String>(message,HttpStatus.CREATED);
				} catch (MovieAlreadyExistsException e) {
					// TODO Auto-generated catch block
//					log.info(e.getMessage());
					responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.IM_USED);
				} catch(Exception e) {
//					log.info(e.getMessage());
					responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.IM_USED);
				}
			return responseEntity;
		}
		
		@PutMapping("updatemovie")
		public ResponseEntity<String> updateMovie(@RequestBody MovieDto movieDto) {
			ResponseEntity<String> responseEntity = null;
			try {
				String message=movieServiceImpl.updateMovie(movieDto);
//				log.info(message+" With Name: "+movieDto.getMovieName());
				responseEntity=new ResponseEntity<String>(message,HttpStatus.CREATED);
			} catch (MovieDoesNotExistsException e) {
				// TODO Auto-generated catch block
//				log.info(e.getMessage());
				responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.IM_USED);
			} catch(Exception e) {
//				log.info(e.getMessage());
				responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.IM_USED);
			}
		return responseEntity;
		}
		
		@DeleteMapping("deletemovie/{moviename}")
		public ResponseEntity<String> deleteMovie(@PathVariable String moviename){
			ResponseEntity<String> responseEntity = null;
			try {
				String message=movieServiceImpl.deleteMovie(moviename);
//				log.info(message+" With Name: "+moviename);
				responseEntity=new ResponseEntity<String>(message,HttpStatus.OK);
			}
			catch (MovieDoesNotExistsException e) {
				// TODO: handle exception
//				log.info(e.getMessage());
				responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.IM_USED);
			} catch (MovieAlreadyDeletedException e) {
				// TODO Auto-generated catch block
//				log.info(e.getMessage());
				responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.IM_USED);
			} catch(Exception e) {
//				log.info(e.getMessage());
				responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.IM_USED);
			}
			return responseEntity;
		}
		
		@GetMapping
		public ResponseEntity<?> getAllMovies(){
			ResponseEntity<?> responseEntity;
			try {
				List<MovieDto> movieList=movieServiceImpl.getMovies();
//				log.info("All Movies Were Fetched From Database");
				responseEntity=new ResponseEntity<List<MovieDto>>(movieList,HttpStatus.OK);
			} catch (MovieDoesNotExistsException e){
				// TODO Auto-generated catch block
//				log.info(e.getMessage());
				responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.IM_USED);
			} catch(Exception e) {
//				log.info(e.getMessage());
				responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.IM_USED);
			}
			return responseEntity;
		}
		
		@GetMapping("getByName/{movieName}")
		public ResponseEntity<?> getMovieByName(@PathVariable String movieName){
			ResponseEntity<?> responseEntity ;
			try {
//				log.info("Movie Details Returned With Name :"+movieName);
				responseEntity=new ResponseEntity<MovieDto>(movieServiceImpl.getMovieByName(movieName),HttpStatus.OK);
			} catch (MovieDoesNotExistsException e) {
				// TODO Auto-generated catch block
//				log.info(e.getMessage());
				responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.IM_USED);
			} catch (MovieAlreadyDeletedException e) {
				// TODO Auto-generated catch block
//				log.info(e.getMessage());
				responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.IM_USED);
			}catch(Exception e) {
//				log.info(e.getMessage());
				responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.IM_USED);
			}
			return responseEntity;
		}
		
		@GetMapping("getByStatus/{status}")
		public ResponseEntity<?> getMovieByStatus(@PathVariable String status){
			ResponseEntity<?> responseEntity ;
			List<MovieDto> moviesList;
			try {
				moviesList = movieServiceImpl.getMoviesByStatus(status);
//				log.info("All "+status+" Movies Were Fetced From Database.");
				responseEntity=new ResponseEntity<List<MovieDto>>(moviesList,HttpStatus.OK);

			} catch (MovieDoesNotExistsException e) {
				// TODO Auto-generated catch block
//				log.info(e.getMessage());
				responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.IM_USED);
			}catch(Exception e) {
//				log.info(e.getMessage());
				responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.IM_USED);
			}
			
			return responseEntity;
		}
		
//		@GetMapping("getByScheduleDateAndMovieName/{date}/{moviename}")
//		public List<MovieDto> etByMovieNameAndScheduleDate(@pa)
//		@GetMapping("getByCast/{castName}")
//		public ResponseEntity<Object> getMovieByCast(@PathVariable String castName){
//			try {
//			return <removieServiceImpl.getMoviesByCast(castName);
//			}
//			catch(MovieAlreadyExistsException exe) {
				
//				Log.Error("message: " + exe.getMessage(), exe.getcode(), exe)
//				
//			
//			}
//			catch(Exception exe) {
//				
//			}
//			return null;
//		}
		

}
