package com.galaxe.movietheatre.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galaxe.movietheatre.dto.ScheduleDto;
import com.galaxe.movietheatre.entities.Schedule;
import com.galaxe.movietheatre.exception.MovieDoesNotExistsException;
import com.galaxe.movietheatre.exception.ScheduleAlreadyBookedException;
import com.galaxe.movietheatre.exception.ScheduleDoesNotExistsException;
import com.galaxe.movietheatre.service.impl.ScheduleServiceImpl;

@RestController
@RequestMapping("schedule")
public class ScheduleController {
	
	@Autowired
	ScheduleServiceImpl scheduleServiceImpl;
	
	@PostMapping("addschedule")
	public ResponseEntity<?> addSchedule(@RequestBody ScheduleDto scheduleDto){
		ResponseEntity<?> responseEntity=null;
		
		try {
			responseEntity= new ResponseEntity<ScheduleDto>(scheduleServiceImpl.addSchedule(scheduleDto),HttpStatus.OK);
		} catch (MovieDoesNotExistsException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		} catch (ScheduleAlreadyBookedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@PutMapping("updateschedule")
	public ResponseEntity<?> updateSchedule(@RequestBody ScheduleDto scheduleDto){
		ResponseEntity<?> responseEntity=null;
		
		
			try {
				responseEntity=new ResponseEntity<ScheduleDto>(scheduleServiceImpl.updateSchedule(scheduleDto),HttpStatus.OK);
			} catch (MovieDoesNotExistsException | ScheduleDoesNotExistsException | ScheduleAlreadyBookedException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
			}  catch(Exception e) {
				System.out.println(e.getMessage());
				responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
			}
		return responseEntity;
	}
	
	@DeleteMapping("deleteschedule/{scheduleId}")
	public ResponseEntity<?> deleteSchedule(@PathVariable int scheduleId){
		ResponseEntity<?> responseEntity=null;
		try {
			responseEntity=new ResponseEntity<String>(scheduleServiceImpl.deleteSchedule(scheduleId),HttpStatus.OK);
		} catch (ScheduleDoesNotExistsException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}  catch(Exception e) {
			System.out.println(e.getMessage());
			responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
		
	@GetMapping
		public ResponseEntity<?> getAllSchedules(){
			ResponseEntity<?> responseEntity=null;
			
				try {
					responseEntity=new ResponseEntity<List<ScheduleDto>>(scheduleServiceImpl.getAllSchedules(),HttpStatus.OK);
				} catch (ScheduleDoesNotExistsException e) {
					// TODO Auto-generated catch block
					responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);

				}   catch(Exception e) {
					//System.out.println(e.getMessage());
					responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
				}	
		return responseEntity;
	}
	
//	@GetMapping("getByScheduleDateAndMovieName/{date}/{moviename}")
//	public ResponseEntity<?> getMovieByDateAndName(@PathVariable String date,@PathVariable String moviename){
//		ResponseEntity<?> responseEntity=null;
//		
//		try {
//			LocalDate scheduleDate=LocalDate.parse(date);
//			responseEntity=new ResponseEntity<List<ScheduleDto>>(scheduleServiceImpl.getMovieByDateAndName(scheduleDate,moviename),HttpStatus.OK);
//		} catch (ScheduleDoesNotExistsException e) {
//			// TODO Auto-generated catch block
//			responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
//		}
//		
//		return responseEntity;
//	}
}
