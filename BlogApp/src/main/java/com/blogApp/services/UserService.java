package com.blogApp.services;

import java.util.List;

import com.blogApp.payload.UserDto;

public interface UserService {

	UserDto createUser(UserDto Users);
	UserDto updateUser(UserDto Users, Integer UsersId);
	UserDto getUserById(Integer UsersId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer Id);
	
}
