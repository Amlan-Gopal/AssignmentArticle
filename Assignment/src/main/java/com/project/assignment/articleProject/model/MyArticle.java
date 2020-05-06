package com.project.assignment.articleProject.model;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class MyArticle {
	
	@NotBlank(message = "Article title cant be blank")
	private String title;
	@NotBlank(message = "Article body cant be blank")
	private String body;
	@NotBlank(message = "Author name cant be blank")
	private String author;
	@NotBlank(message = "Access token cant be blank")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String access_token;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@JsonIgnore
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
}
