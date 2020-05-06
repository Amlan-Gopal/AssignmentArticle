package com.project.assignment.articleProject.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.assignment.articleProject.entity.Article;
import com.project.assignment.articleProject.entity.User;

@Repository
public interface ArticleRepo extends JpaRepository<User, Integer>{

	@Query("select user from User user where user.userName = ?1")
	User findUserByUserName(String userName);
	
	@Query("select article from Article article")
	Collection<Article> findArticles();
}
