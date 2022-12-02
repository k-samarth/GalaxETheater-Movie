package com.galaxe.movietheatre.service;

import com.galaxe.movietheatre.dto.UserDto;

public interface UserService {
	public  String saveUser(UserDto userDto);
	public boolean emailAlreadyExists(String email);
	public UserDto getUserByEmail(String email);
}
