package com.soprasteria.ivan.movies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Movie not found in the database!")
public class MovieNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}