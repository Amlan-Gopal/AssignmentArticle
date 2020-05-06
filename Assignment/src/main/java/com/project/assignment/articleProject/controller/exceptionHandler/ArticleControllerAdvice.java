package com.project.assignment.articleProject.controller.exceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.project.assignment.articleProject.exceptions.BadInputException;
import com.project.assignment.articleProject.exceptions.EntityNotFoundException;
import com.project.assignment.articleProject.exceptions.EntityNotSaved;
import com.project.assignment.articleProject.model.ExceptionResponse;

@ControllerAdvice
public class ArticleControllerAdvice {
	
	@ExceptionHandler({EntityNotFoundException.class, BadInputException.class})
	public ResponseEntity<ExceptionResponse> handleUserInputException(Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({EntityNotSaved.class})
	public ResponseEntity<ExceptionResponse> handleEntityNotSavedException(Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.SERVICE_UNAVAILABLE);
	}

}
