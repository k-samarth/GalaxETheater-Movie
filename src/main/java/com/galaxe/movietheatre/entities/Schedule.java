package com.galaxe.movietheatre.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Entity
public class Schedule  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int scheduleId;
	
//	@Column(unique = true)
//	private long scheduleCode;
	private LocalDate scheduleDate;
	private LocalTime scheduleTime;
	private String theatreName;
	
	@ManyToOne
	@JoinColumn(name="moviename" ,referencedColumnName = "movieName")
	private Movie movie;

	private final static AtomicLong subIdCounter = new AtomicLong(System.nanoTime());

}
