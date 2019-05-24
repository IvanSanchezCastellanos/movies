package com.soprasteria.ivan.movies.controllers;

import java.util.List;

import com.soprasteria.ivan.movies.model.entities.Movie;
import com.soprasteria.ivan.movies.service.dto.movie.MovieFullDTO;
import com.soprasteria.ivan.movies.service.dto.movie.MovieYearTitleDTO;

public interface MovieControllerInterface {

	Movie saveMovie(MovieFullDTO movie);

	MovieFullDTO getMovie(Long id);

	List<MovieYearTitleDTO> findTitleYear();

}