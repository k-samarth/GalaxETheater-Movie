package com.galaxe.movietheatre.dto;

import java.time.LocalDate;

import com.galaxe.movietheatre.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private String firstName;
	private String lastName;
	private Gender gender;
	private LocalDate dateOfBirth;
	private long homeMobileNo;
	private long mobileNo;
	private String email;
	private String userName;
	private String password;
}
