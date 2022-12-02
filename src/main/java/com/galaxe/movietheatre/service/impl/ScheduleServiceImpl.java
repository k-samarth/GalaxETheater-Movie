package com.galaxe.movietheatre.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxe.movietheatre.dto.ScheduleDto;
import com.galaxe.movietheatre.entities.Movie;
import com.galaxe.movietheatre.entities.Schedule;
import com.galaxe.movietheatre.exception.MovieDoesNotExistsException;
import com.galaxe.movietheatre.exception.ScheduleAlreadyBookedException;
import com.galaxe.movietheatre.exception.ScheduleDoesNotExistsException;
import com.galaxe.movietheatre.mapper.ScheduleMapper;
import com.galaxe.movietheatre.repository.MovieRepository;
import com.galaxe.movietheatre.repository.ScheduleRepository;
import com.galaxe.movietheatre.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	ScheduleRepository scheduleRepository;
	
	@Autowired
	ScheduleMapper scheduleMapper;
	@Override
	public ScheduleDto addSchedule(ScheduleDto scheduleDto) throws MovieDoesNotExistsException, ScheduleAlreadyBookedException {
	
		// TODO Auto-generated method stub
		Movie movie=movieRepository.findByMovieName(scheduleDto.getMovieName());
		if(movie==null)
			throw new MovieDoesNotExistsException("Sorry ! Movie Does Not Exists.");
		Schedule schedule=scheduleRepository.findByScheduleId(scheduleDto.getScheduleId());
		schedule=scheduleRepository.findByScheduleDateAndScheduleTimeAndTheatreName(scheduleDto.getScheduleDate(),scheduleDto.getScheduleTime(),scheduleDto.getTheatreName());
		if(schedule!=null)
			throw new ScheduleAlreadyBookedException("Schedule With Given Details Is Already Available.");
		schedule=scheduleMapper.convertToEntity(scheduleDto);
		schedule.setMovie(movie); 
		ScheduleDto scheDto=scheduleMapper.convertToDto(scheduleRepository.save(schedule));
		scheDto.setMovieName(movie.getMovieName());
		return scheDto;
	}

	@Override
	public ScheduleDto updateSchedule(ScheduleDto scheduleDto) throws MovieDoesNotExistsException, ScheduleDoesNotExistsException, ScheduleAlreadyBookedException {
		// TODO Auto-generated method stub
		Movie movie=movieRepository.findByMovieName(scheduleDto.getMovieName());
		if(movie==null)
			throw new MovieDoesNotExistsException("Sorry ! Movie Does Not Exists.");
		Schedule schedule=scheduleRepository.findByScheduleId(scheduleDto.getScheduleId());
		if(schedule==null)
			throw new ScheduleDoesNotExistsException("Schedule Does Not Exists");
		int scheduleId=schedule.getScheduleId();
		schedule=scheduleRepository.findByScheduleDateAndScheduleTimeAndTheatreName(scheduleDto.getScheduleDate(),scheduleDto.getScheduleTime(),scheduleDto.getTheatreName());
		if(schedule!=null)
			throw new ScheduleAlreadyBookedException("Schedule With Given Details Is Not Available.");
		schedule=scheduleMapper.convertToEntity(scheduleDto);
		schedule.setScheduleId(scheduleId);
		schedule.setMovie(movie);
		ScheduleDto scheDto=scheduleMapper.convertToDto(scheduleRepository.save(schedule));
		scheDto.setMovieName(movie.getMovieName());
		return scheDto;
	}

	@Override
	public String deleteSchedule(int scheduleId) {   //throws ScheduleDoesNotExistsException 
		// TODO Auto-generated method stub
		Schedule schedule=scheduleRepository.findByScheduleId(scheduleId);
		if(schedule==null)
			throw new ScheduleDoesNotExistsException("Schedule Does Not EXists For Given Schedule Code.");
		scheduleRepository.delete(schedule);
		return "Schedule Deleted Successfully";
	}

	@Override
	public List<ScheduleDto> getAllSchedules() throws ScheduleDoesNotExistsException {
		// TODO Auto-generated method stub
		List<Schedule> scheduleList=scheduleRepository.findAll();
		if(scheduleList.isEmpty())
			throw new ScheduleDoesNotExistsException("No Schedule Exists");
		List<ScheduleDto> scheduleDtoList=new ArrayList<ScheduleDto>();
		for(Schedule schedule:scheduleList) {
			ScheduleDto s=scheduleMapper.convertToDto(schedule);
			s.setMovieName(schedule.getMovie().getMovieName());
			scheduleDtoList.add(s);
		}
		return scheduleDtoList;
	}

//	public List<ScheduleDto> getMovieByDateAndName(LocalDate date, String moviename) throws ScheduleDoesNotExistsException {
//		// TODO Auto-generated method stub
//		Movie movie=movieRepository.findByMovieName(moviename);
//		List<Schedule> scheduList=scheduleRepository.findByScheduleDateAndMovie(date,movie);
//		if(scheduList.isEmpty())
//			throw new ScheduleDoesNotExistsException("Schedule Does Not Exist");
//		System.out.println(scheduList);
//		List<Movies> movieList=new ArrayList<ScheduleDto>();
//		for(Schedule schedule:scheduList)
//			scheduleDtoList.add(scheduleMapper.convertToDto(schedule));
//		return scheduleDtoList;
//	}

}
