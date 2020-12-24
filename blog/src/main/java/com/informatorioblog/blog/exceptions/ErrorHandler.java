package com.informatorioblog.blog.exceptions;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ErrorMessage methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
		BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        
        StringBuilder errorMessage = new StringBuilder();
        fieldErrors.forEach(f -> errorMessage.append(f.getField() + " " + f.getDefaultMessage() + " "));
        
        return new ErrorMessage(errorMessage.toString(), HttpStatus.BAD_REQUEST.value(), request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseBody
	public ErrorMessage httpMessageNotReadableException (HttpServletRequest request, HttpMessageNotReadableException e) {
		
		return new ErrorMessage(e.getMostSpecificCause().getMessage(), HttpStatus.BAD_REQUEST.value(), request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NumberFormatException.class)
	@ResponseBody
	public ErrorMessage numberFormatException (HttpServletRequest request, NumberFormatException e) {
		
		return new ErrorMessage(e.getMessage(), HttpStatus.BAD_REQUEST.value(), request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidDataAccessApiUsageException.class)
	@ResponseBody
	public ErrorMessage invalidDataAccessApiUsageException (HttpServletRequest request, InvalidDataAccessApiUsageException e) {
		
		return new ErrorMessage(e.getMostSpecificCause().getMessage(), HttpStatus.BAD_REQUEST.value(), request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseBody
	public ErrorMessage illegalArgumentException (HttpServletRequest request, IllegalArgumentException e) {
		
		return new ErrorMessage(e.getMessage(), HttpStatus.BAD_REQUEST.value(), request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	public ErrorMessage constraintViolationException (HttpServletRequest request, ConstraintViolationException e) {
		
		return new ErrorMessage(e.getMessage(), HttpStatus.BAD_REQUEST.value(), request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseBody
	public ErrorMessage entityNotFoundException(HttpServletRequest request, EntityNotFoundException e) {
		
        return new ErrorMessage(e.getMessage(), HttpStatus.NOT_FOUND.value(), request.getRequestURI());	
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmptyResultDataAccessException.class)
	@ResponseBody
	public ErrorMessage emptyResultDataAccessException(HttpServletRequest request, EmptyResultDataAccessException e) {
		
        return new ErrorMessage(e.getMessage(), HttpStatus.NOT_FOUND.value(), request.getRequestURI());	
	}
	
	
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseBody
	public ErrorMessage dataIntegrityViolationException(HttpServletRequest request, DataIntegrityViolationException e) {
		
		return new ErrorMessage(e.getMostSpecificCause().getMessage(), HttpStatus.CONFLICT.value(), request.getRequestURI());
	}
	
	
	
}
