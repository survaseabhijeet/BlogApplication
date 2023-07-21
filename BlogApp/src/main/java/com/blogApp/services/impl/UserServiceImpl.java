package com.blogApp.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.blogApp.exceptions.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.blogApp.entities.Users;
import com.blogApp.payload.UserDto;
import com.blogApp.repositories.UserRepo;
import com.blogApp.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		Users users = this.dtoToUser(userDto);
		Users userCreated = this.userRepo.save(users);
		return this.userToDto(userCreated);
	}

	@Override
	public UserDto updateUser(UserDto usersDto, Integer usersId) {
		Users user = this.userRepo.findById(usersId).orElseThrow(()-> new ResourceNotFoundException("Users", "Id", usersId));
		
		user.setName(usersDto.getName());
		user.setEmail(usersDto.getEmail());
		user.setPassword(usersDto.getPassword());
		user.setAbout(usersDto.getAbout());
		
		Users updateduser=this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updateduser);
		
		return userDto1 ;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		Users user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Users","id",userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<Users> listOfUsers=this.userRepo.findAll();
		
		List<UserDto> userDtos=listOfUsers.stream().map(users-> this.userToDto(users)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		
		Users deleteUser=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Users","id",userId));
		this.userRepo.delete(deleteUser);
		
	}
	
	public Users dtoToUser(UserDto userDto) {
		Users user= this.modelMapper.map(userDto, Users.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
//		
	return user;
	}
	
	public UserDto userToDto(Users user) {
		
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		
		return userDto;
	}

}
