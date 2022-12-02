package com.galaxe.movietheatre.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.galaxe.movietheatre.enums.Code;
import com.galaxe.movietheatre.enums.Language;
import com.galaxe.movietheatre.enums.MovieStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "movieId")
public class Movie implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;

	private Code movieCode;
	private String movieUrl;
	private String movieName;
	private String movieGenre;
	private LocalDate releaseDate;
	private String duration;
	private MovieStatus movieStatus;
	private String rating;
	private Language language;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "movie_cast_table", joinColumns = {
			@JoinColumn(name = "movie_id", referencedColumnName = "movieId") }, inverseJoinColumns = {
					@JoinColumn(name = "cast_id", referencedColumnName = "castId") })
	// @JsonManagedReference
	private List<Cast> cast;
	
}