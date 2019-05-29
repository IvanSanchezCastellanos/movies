package com.soprasteria.ivan.movies.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.soprasteria.ivan.movies.builder.entities.ActorBuilder;
import com.soprasteria.ivan.movies.exceptions.InvalidInputException;
import com.soprasteria.ivan.movies.exceptions.MovieAlreadyInDatabaseException;
import com.soprasteria.ivan.movies.exceptions.MovieNotFoundException;
import com.soprasteria.ivan.movies.model.entities.Actor;
import com.soprasteria.ivan.movies.model.entities.Movie;
import com.soprasteria.ivan.movies.model.repositories.ActorRepository;
import com.soprasteria.ivan.movies.model.repositories.MovieRepository;
import com.soprasteria.ivan.movies.service.dto.movie.MovieFullDTO;
import com.soprasteria.ivan.movies.service.dto.movie.MovieYearTitleDTO;
import com.soprasteria.ivan.movies.service.dto.movie.TransformMovie;

@Service
public class MovieServiceImplementation implements MovieServiceInterface {

	private final MovieRepository movieRepository;
	private final ActorRepository actorRepository;

	public MovieServiceImplementation(MovieRepository movieRepository, ActorRepository actorRepository) {
		this.movieRepository = movieRepository;
		this.actorRepository = actorRepository;
	}

	public MovieFullDTO getMovie(Long id) {
		return TransformMovie
				.fromMovieToMovieFullDTO(movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException()));
	}

	public Movie saveMovie(MovieFullDTO movieDTO) {

		if (movieDTO == null) {
			throw new InvalidInputException();
		}

		if (movieRepository.findMovie(movieDTO.getTitle(), movieDTO.getGenre(), movieDTO.getYear()).isPresent()) {
			throw new MovieAlreadyInDatabaseException();
		}

		Movie movie = TransformMovie.fromMovieDTOToMovie(movieDTO);

		movie.setActors(movie.getActors().stream().map(
				
			(Actor actor) -> {

			Optional<Actor> findActor = actorRepository.findActor(actor.getName(), actor.getSurnames(), actor.getAge());

			if (!findActor.isPresent()) {
				Actor actor2 = new ActorBuilder().name(actor.getName(), actor.getSurnames())
												 .age(actor.getAge())
												 .build();
				actorRepository.save(actor2);
				return actor2;
			} else {
				return findActor.get();
			}
			
		}).collect(Collectors.toList()));

		return movieRepository.save(movie);

	}

	public List<MovieYearTitleDTO> findTitleYear() {
		return TransformMovie.fromMovieListToMovieYearTitleDTOList(movieRepository.findAll());
	}

}