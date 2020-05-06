package com.project.assignment.articleProject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.assignment.articleProject.model.MyArticle;
import com.project.assignment.articleProject.model.AllArticles;
import com.project.assignment.articleProject.model.LogInResponse;
import com.project.assignment.articleProject.model.Messageresponse;
import com.project.assignment.articleProject.model.MyUser;
import com.project.assignment.articleProject.model.UserPwd;
import com.project.assignment.articleProject.service.ArticleService;

@RestController
@Validated
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	@PostMapping("/login")
	public LogInResponse login(@Valid @RequestBody UserPwd userPwd) {
		
		LogInResponse response = articleService.doLogIn(userPwd);
		return response;
	}
	
	@PostMapping("/register")
	public ResponseEntity<Messageresponse> register(@Valid @RequestBody MyUser user) {
		boolean isCreated = articleService.register(user);
		Messageresponse response = new Messageresponse();
		if(isCreated) {
			response.setMessage("New user created");
		}
		return new ResponseEntity<Messageresponse>(response, HttpStatus.CREATED);
	}
	
	@PostMapping("/articles")
	public ResponseEntity<Messageresponse> createArticle(@Valid @RequestBody MyArticle article){
		
		Messageresponse response = new Messageresponse();
		boolean isCreated = articleService.createArticle(article);
		if(isCreated) {
			response.setMessage("New article created");
		}
		return new ResponseEntity<Messageresponse>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/articles")
	public AllArticles getAllArticles(){
		
		AllArticles allArticles = articleService.getAllArticles();
		return allArticles;
	}
	
}
