package com.blogApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogApp.entities.Users;

public interface UserRepo extends JpaRepository <Users, Integer>  {
	
}
