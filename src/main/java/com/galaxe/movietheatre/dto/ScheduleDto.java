package com.galaxe.movietheatre.dto;

import java.time.LocalDate;
import java.time.LocalTime;


import com.galaxe.movietheatre.entities.Movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDto {
	private int scheduleId;
	private LocalDate scheduleDate;
	private LocalTime scheduleTime;
	private String theatreName;
	private String movieName;
}
