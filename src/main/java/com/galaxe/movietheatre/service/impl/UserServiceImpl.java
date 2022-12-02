package com.galaxe.movietheatre.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxe.movietheatre.dto.UserDto;
import com.galaxe.movietheatre.entities.User;
import com.galaxe.movietheatre.enums.Role;
import com.galaxe.movietheatre.mapper.UserMapper;
import com.galaxe.movietheatre.repository.UserRepository;
import com.galaxe.movietheatre.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserMapper userMapper;
	public  String saveUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user=userMapper.convertToEntity(userDto);
		if(user.getHomeMobileNo()==1)
			user.setRole(Role.ADMIN);
		userRepository.save(user);
		//user.setUserId(12);
		System.out.println(user);
		return "User Created Successfully";
	}
	public boolean emailAlreadyExists(String email) {
		// TODO Auto-generated method stub
		
		Optional<User> user=userRepository.findByEmail(email);
		return user.isPresent();
	}
	public UserDto getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userMapper.convertToDto(userRepository.findByEmail(email).get());
	}
}
