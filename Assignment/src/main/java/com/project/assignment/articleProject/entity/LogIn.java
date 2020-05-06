package com.project.assignment.articleProject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class LogIn {

	@Id
	@NotBlank(message = "Token cant be blank")
	private String accessToken;
	@NotNull(message = "User account should be available")
	@ManyToOne
	private User user;
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private List<Article> articles;
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
}
