package com.blogApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogApp.payload.UserDto;
import com.blogApp.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// Post- create User
	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);

	}

	// update a user
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId) {
		UserDto updatedUser = this.userService.updateUser(userDto, userId);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);

	}

	// delete a user
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") Integer userId) {
		this.userService.deleteUser(userId);
		// return new ResponseEntity(Map.of("Message" , "User Deleted Successfully")
		// ,HttpStatus.OK);
		return new ResponseEntity<>(("User Deleted Successfully"), HttpStatus.OK);
	}

	// get all users
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return ResponseEntity.ok(this.userService.getAllUsers());

	}

	// get user by id
	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId) {
		return ResponseEntity.ok(this.userService.getUserById(userId));

	}

}
