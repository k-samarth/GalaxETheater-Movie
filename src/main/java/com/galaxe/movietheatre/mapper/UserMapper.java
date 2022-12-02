package com.galaxe.movietheatre.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import com.galaxe.movietheatre.dto.UserDto;
import com.galaxe.movietheatre.entities.User;

@Mapper
public interface UserMapper {
	@Mapping(target="firstName",source="userDto.firstName")
	@Mapping(target="lastName",source="userDto.lastName")
	@Mapping(target="gender",source="userDto.gender")
	@Mapping(target="dateOfBirth",source="userDto.dateOfBirth")
	@Mapping(target="homeMobileNo",source="userDto.homeMobileNo")
	@Mapping(target="mobileNo",source="userDto.mobileNo")
	@Mapping(target="email",source="userDto.email")
	@Mapping(target="userName",source="userDto.userName")
	@Mapping(target="password",source="userDto.password")
	public User convertToEntity(UserDto userDto);
	
	@Mapping(target="firstName",source="user.firstName")
	@Mapping(target ="lastName",source="user.lastName")
	@Mapping(target="gender",source="user.gender")
	@Mapping(target="dateOfBirth",source="user.dateOfBirth")
	@Mapping(target="homeMobileNo",source="user.homeMobileNo")
	@Mapping(target="mobileNo",source="user.mobileNo")
	@Mapping(target="email",source="user.email")
	@Mapping(target="userName",source="user.userName")
	@Mapping(target="password",source="user.password")
	public UserDto convertToDto(User user);
}
