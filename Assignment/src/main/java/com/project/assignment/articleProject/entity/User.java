package com.project.assignment.articleProject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@NotBlank(message = "User name cant be blank")
	private String userName;
	@NotBlank(message = "Password cant be blank")
	private String password;
	@NotBlank(message = "Email cant be blank")
	@Email(message = "Proper email is needed")
	private String email;
	@NotBlank(message = "Address cant be blank")
	private String address;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<LogIn> logIns;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public List<LogIn> getLogIns() {
		return logIns;
	}
	public void setLogIns(List<LogIn> logIns) {
		this.logIns = logIns;
	}
	
	
	
	
	

}
