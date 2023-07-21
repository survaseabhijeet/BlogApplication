package com.blogApp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="user_name", nullable= false, length=100)
	private String name;
	
	@Column(name="user_email", nullable= false, length=100)
	private String Email;
	
	@Column(name="user_password", nullable= false, length=100)
	private String password;
	
	@Column(name="about_user", nullable= false, length=100)
	private String about;

	public Users() {
		super();
		
	}

	public Users(int id, String name, String email, String password, String about) {
		super();
		this.id = id;
		this.name = name;
		Email = email;
		this.password = password;
		this.about = about;
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
		return "Users [id=" + id + ", name=" + name + ", Email=" + Email + ", password=" + password + ", about=" + about
				+ "]";
	}

	
	
	
}
