package com.project.assignment.articleProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.assignment.articleProject.entity.Article;
import com.project.assignment.articleProject.entity.LogIn;
import com.project.assignment.articleProject.entity.User;
import com.project.assignment.articleProject.exceptions.BadInputException;
import com.project.assignment.articleProject.exceptions.EntityNotFoundException;
import com.project.assignment.articleProject.exceptions.EntityNotSaved;
import com.project.assignment.articleProject.model.MyArticle;
import com.project.assignment.articleProject.model.AllArticles;
import com.project.assignment.articleProject.model.LogInResponse;
import com.project.assignment.articleProject.model.MyUser;
import com.project.assignment.articleProject.model.UserPwd;
import com.project.assignment.articleProject.repository.ArticleRepo;

@Service
public class ArticleService {
	
	@Autowired
	ArticleRepo articleRepo;
	
	public LogInResponse doLogIn(UserPwd userPwd) {
		
		User user = articleRepo.findUserByUserName(userPwd.getUsername());
		String accessToken="";
		boolean isLoggedIn = false;
		
		if(user != null) {
			if(user.getPassword().equals(userPwd.getPassword())) {
				LogIn logIn = new LogIn();
				logIn.setUser(user);
				accessToken = getAccessToken();
				logIn.setAccessToken(accessToken);
				List<Article> articles = new ArrayList<>();
				logIn.setArticles(articles);
				user.getLogIns().add(logIn);
				isLoggedIn = saveUser(user);
			}else {
				throw new BadInputException("Password is incorrect");
			}
		}else {
			throw new EntityNotFoundException("User has not been registered");
		}
		
		LogInResponse response = new LogInResponse();
		if(isLoggedIn) {
			response.setMessage("success");
			response.setAccessToken(accessToken);
		}
		
		return response;
	} 

	public boolean register(MyUser myUser) {
		
		User user = new User();
		user.setUserName(myUser.getUsername());
		user.setPassword(myUser.getPassword());
		user.setEmail(myUser.getEmail());
		user.setAddress(myUser.getAddress());
		List<LogIn> logIns = new ArrayList<>();
		user.setLogIns(logIns);
		boolean isSaved = saveUser(user);
		return isSaved;
	}

	public boolean createArticle(MyArticle ipArticle) {
		
		boolean isCreated = false;
		boolean isMatched = false;
		
		User user = articleRepo.findUserByUserName(ipArticle.getAuthor());
		if(user != null) {
			List<LogIn> logIns = user.getLogIns();
			for(LogIn logIn : logIns) {
				if(logIn.getAccessToken().equals(ipArticle.getAccess_token())) {
					isMatched = true;
					Article article = new Article();
					article.setAuthor(logIn);
					article.setTitle(ipArticle.getTitle());
					article.setBody(ipArticle.getBody());
					logIn.getArticles().add(article);
					isCreated = saveUser(user);
					break;
				}
			}
			if(!isMatched) {
				throw new BadInputException("Log-in is required");
			}
		}else {
			throw new EntityNotFoundException("User has not been registered");
		}
		
		return isCreated;
	}
	
	public AllArticles getAllArticles(){
		
		List<Article> savedArticles = articleRepo.findArticles().stream().collect(Collectors.toList());
		List<MyArticle> articles = new ArrayList<>();
		
		for(Article articleEnty : savedArticles) {
			
			MyArticle article = new MyArticle();
			article.setTitle(articleEnty.getTitle());
			article.setBody(articleEnty.getBody());
			String authorName = articleEnty.getAuthor().getUser().getUserName();
			article.setAuthor(authorName);
			
			articles.add(article);
		}
		
		AllArticles allArticles = new AllArticles();
		allArticles.setData(articles);
		
		return allArticles;
	}
	
	private String getAccessToken() {
		
		final String ALPHA_NUM_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
		final int SIZE = 36;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i < SIZE; i++) {
			int index = (int)(ALPHA_NUM_STRING.length() * Math.random());
			sb.append(ALPHA_NUM_STRING.charAt(index));
		}
		return sb.toString();
	}
	
	private boolean saveUser(User user) {
	User savedUser = articleRepo.save(user);
		
		boolean isSaved = savedUser != null;	
		if(!isSaved) {
			throw new EntityNotSaved("Data could not be saved");
		}
		return isSaved;
	}
}
