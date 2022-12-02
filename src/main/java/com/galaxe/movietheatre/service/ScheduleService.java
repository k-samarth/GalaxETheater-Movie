package com.galaxe.movietheatre.service;

import java.util.List;

import com.galaxe.movietheatre.dto.ScheduleDto;
import com.galaxe.movietheatre.entities.Schedule;
import com.galaxe.movietheatre.exception.MovieDoesNotExistsException;
import com.galaxe.movietheatre.exception.ScheduleAlreadyBookedException;
import com.galaxe.movietheatre.exception.ScheduleDoesNotExistsException;

public interface ScheduleService {
	public ScheduleDto addSchedule(ScheduleDto scheduleDto) throws MovieDoesNotExistsException, ScheduleAlreadyBookedException;
	public ScheduleDto updateSchedule(ScheduleDto scheduleDto) throws MovieDoesNotExistsException, ScheduleDoesNotExistsException, ScheduleAlreadyBookedException;
	public String deleteSchedule(int scheduleCode) throws ScheduleDoesNotExistsException;
	public List<ScheduleDto> getAllSchedules() throws ScheduleDoesNotExistsException;
}
