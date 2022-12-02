package com.galaxe.movietheatre.exception;

import org.springframework.http.HttpStatus;

public class MovieAlreadyExistsException extends RuntimeException{
	HttpStatus code; 
	public MovieAlreadyExistsException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
	
	public MovieAlreadyExistsException(String msg, HttpStatus code) {
		// TODO Auto-generated constructor stub
		super(msg);
		this.code=code;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}

	public MovieAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MovieAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MovieAlreadyExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}
	
}
