package com.galaxe.movietheatre.exception;

public class MovieAlreadyDeletedException extends RuntimeException {

	public MovieAlreadyDeletedException() {
		// TODO Auto-generated constructor stub
	}

	public MovieAlreadyDeletedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MovieAlreadyDeletedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public MovieAlreadyDeletedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MovieAlreadyDeletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

}
