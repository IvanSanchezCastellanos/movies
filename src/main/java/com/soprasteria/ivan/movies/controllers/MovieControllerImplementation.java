package com.soprasteria.ivan.movies.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.ivan.movies.exceptions.InvalidInputException;
import com.soprasteria.ivan.movies.exceptions.MovieAlreadyInDatabaseException;
import com.soprasteria.ivan.movies.model.entities.Movie;
import com.soprasteria.ivan.movies.service.MovieServiceImplementation;
import com.soprasteria.ivan.movies.service.dto.movie.MovieFullDTO;
import com.soprasteria.ivan.movies.service.dto.movie.MovieYearTitleDTO;

@RestController
public class MovieControllerImplementation implements MovieControllerInterface {

	private final MovieServiceImplementation movieService;

	@Autowired
	public MovieControllerImplementation(MovieServiceImplementation service) {
		this.movieService = service;

	}

	@GetMapping("/movie/{id}")
	public MovieFullDTO getMovie(@PathVariable Long id) {
		return movieService.getMovie(id);

	}

	@PostMapping("/movie")
	public Movie saveMovie(@RequestBody MovieFullDTO movie)
			throws InvalidInputException, MovieAlreadyInDatabaseException {
		return movieService.saveMovie(movie);

	}

	@GetMapping("/movie")
	public List<MovieYearTitleDTO> findTitleYear() {
		return movieService.findTitleYear();

	}

}