package com.soprasteria.ivan.movies.service.dto.movie;

import java.util.List;
import java.util.stream.Collectors;

import com.soprasteria.ivan.movies.builder.dto.movie.MovieFullDTOBuilder;
import com.soprasteria.ivan.movies.builder.dto.movie.MovieYearTitleDTOBuilder;
import com.soprasteria.ivan.movies.builder.entities.MovieBuilder;
import com.soprasteria.ivan.movies.model.entities.Movie;
import com.soprasteria.ivan.movies.service.dto.actor.TransformActor;

public class TransformMovie {

	public static List<MovieYearTitleDTO> fromMovieListToMovieYearTitleDTOList(List<Movie> movies) {

		if (movies != null) {

			return movies.stream().map(TransformMovie::mapMovieToMovieYearDTO).collect(Collectors.toList());

		}

		return null;

	}

	public static MovieYearTitleDTO mapMovieToMovieYearDTO(Movie movie) {
		return new MovieYearTitleDTOBuilder().title(movie.getTitle())
											 .year(movie.getYear())
											 .build();

	}

	public static MovieFullDTO fromMovieToMovieFullDTO(Movie movie) {

		if (movie != null) {
			return new MovieFullDTOBuilder().title(movie.getTitle())
											.genre(movie.getGenre())
											.year(movie.getYear())
											.actors(TransformActor.fromActorListToActorFullDTOList(movie.getActors())).build();

		}

		return null;

	}

	public static Movie fromMovieDTOToMovie(MovieFullDTO movieDTO) {
		if (movieDTO != null) {
			return new MovieBuilder().title(movieDTO.getTitle())
									 .genre(movieDTO.getGenre())
									 .year(movieDTO.getYear())
									 .actors(TransformActor.fromActorFullDTOListToActorList(movieDTO.getActors())).build();

		}

		return null;

	}

}