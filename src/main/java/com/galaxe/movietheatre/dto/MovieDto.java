package com.galaxe.movietheatre.dto;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.galaxe.movietheatre.entities.Cast;
import com.galaxe.movietheatre.enums.Code;
import com.galaxe.movietheatre.enums.Language;
import com.galaxe.movietheatre.enums.MovieStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
	private Code movieCode;
	private String movieUrl;
	private String movieName;
	private String movieGenre;
	private LocalDate releaseDate;
	private String duration;
	private MovieStatus movieStatus;
	private String rating;
	private Language language;
	private List<Cast> cast;
}
