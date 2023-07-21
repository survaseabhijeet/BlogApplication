package com.blogApp.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {

	
	
	private int id;
	private String name;
	private String Email;
	private String password;
	private String about;
	
	
	
	public UserDto(int id, String name, String email, String password, String about) {
		super();
		this.id = id;
		this.name = name;
		Email = email;
		this.password = password;
		this.about = about;
	}
	
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}


	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", Email=" + Email + ", password=" + password + ", about="
				+ about + "]";
	}
	

	
}
