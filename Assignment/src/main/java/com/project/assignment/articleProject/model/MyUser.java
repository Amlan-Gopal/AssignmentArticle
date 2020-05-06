package com.project.assignment.articleProject.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class MyUser {
	
	@NotBlank(message = "User name cant be blank")
	private String username;
	@NotBlank(message = "Password cant be blank")
	private String password;
	@NotBlank(message = "Email cant be blank")
	@Email(message = "Proper email is needed")
	private String email;
	@NotBlank(message = "Address cant be blank")
	private String address;
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
