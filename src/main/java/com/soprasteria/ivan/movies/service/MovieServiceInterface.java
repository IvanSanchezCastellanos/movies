package com.soprasteria.ivan.movies.service;

import java.util.List;

import com.soprasteria.ivan.movies.model.entities.Movie;
import com.soprasteria.ivan.movies.service.dto.movie.MovieFullDTO;
import com.soprasteria.ivan.movies.service.dto.movie.MovieYearTitleDTO;

public interface MovieServiceInterface {

	MovieFullDTO getMovie(Long id);

	Movie saveMovie(MovieFullDTO movieDTO);

	List<MovieYearTitleDTO> findTitleYear();

}