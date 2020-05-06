package com.project.assignment.articleProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int articleId;
	@NotBlank(message = "Article title cant be blank")
	private String title;
	@NotBlank(message = "Article body cant be blank")
	private String body;
	@NotNull(message = "Author details should be provided..Please log-in first")
	@ManyToOne
	private LogIn author;
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
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
	public LogIn getAuthor() {
		return author;
	}
	public void setAuthor(LogIn author) {
		this.author = author;
	}
	
	
	
}
