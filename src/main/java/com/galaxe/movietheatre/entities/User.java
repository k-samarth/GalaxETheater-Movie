package com.galaxe.movietheatre.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.galaxe.movietheatre.enums.Gender;
import com.galaxe.movietheatre.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String firstName;
	private String lastName;
	private Gender gender;
	private LocalDate dateOfBirth;
	private long homeMobileNo;
	private long mobileNo;
	private String email;
	private String userName;
	private String password;
	private Role role;
	
}
