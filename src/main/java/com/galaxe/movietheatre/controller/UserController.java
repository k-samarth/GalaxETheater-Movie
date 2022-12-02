package com.galaxe.movietheatre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galaxe.movietheatre.dto.UserDto;
import com.galaxe.movietheatre.entities.User;
import com.galaxe.movietheatre.service.impl.UserServiceImpl;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	UserServiceImpl userServiceImpl;
	@PostMapping("signup")
	public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
		ResponseEntity<String> responseEntity = null;
		if(userServiceImpl.emailAlreadyExists(userDto.getEmail())) {
			responseEntity=new ResponseEntity<String>("Email Already Registerd",HttpStatus.IM_USED);
			System.out.println("In email");
		}
		else {
			System.out.println(userDto);
			String msg=userServiceImpl.saveUser(userDto);
			responseEntity=new ResponseEntity<String>(msg,HttpStatus.OK);
			System.out.println("out");
		}
		
		return responseEntity;
	}
	@PostMapping("login")
	public ResponseEntity<String> getEmailId(@RequestBody UserDto userdto){
		ResponseEntity<String> responseEntity;
		if(userServiceImpl.emailAlreadyExists(userdto.getEmail())) {
			UserDto user=userServiceImpl.getUserByEmail(userdto.getEmail());
			if(userdto.getPassword().equals(user.getPassword())) {
				responseEntity=new ResponseEntity<String>("Logged in successfully",HttpStatus.OK);
			}
			else {
				responseEntity=new ResponseEntity<String>("Wrong Password!!",HttpStatus.IM_USED) ; //417
			}
			
		}
		else {
			responseEntity=new ResponseEntity<String>("Email Doesn't Exist!",HttpStatus.IM_USED);
		}
		return responseEntity;
	}
}
