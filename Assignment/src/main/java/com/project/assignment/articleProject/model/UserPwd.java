package com.project.assignment.articleProject.model;

import javax.validation.constraints.NotBlank;

public class UserPwd {
	
	@NotBlank(message = "User name cant be blank")
	private String username;
	@NotBlank(message = "Password cant be blank")
	private String password;
	
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
	
	

}
