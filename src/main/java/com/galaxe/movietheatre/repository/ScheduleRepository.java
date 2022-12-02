package com.galaxe.movietheatre.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.galaxe.movietheatre.entities.Movie;
import com.galaxe.movietheatre.entities.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
	public Schedule findByScheduleDateAndScheduleTimeAndTheatreName(LocalDate scheduleDate,LocalTime scheduleTime,String theatreName);

	public Schedule findByScheduleId(int scheduleId);

	public List<Schedule> findByScheduleDateAndMovie(LocalDate date, Movie movie);
}
