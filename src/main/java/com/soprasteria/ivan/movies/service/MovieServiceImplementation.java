package com.soprasteria.ivan.movies.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

		Movie movie = TransformMovie.fromMovieDTOToMovie(movieDTO);
		if (movieRepository.findMovie(movie.getTitle(), movie.getGenre(), movie.getYear()).isPresent()) {
			throw new MovieAlreadyInDatabaseException();

		}

		List<Actor> actors = new ArrayList<Actor>();

		movie.getActors().forEach((Actor actor) -> {
			Optional<Actor> findActor = actorRepository.findActor(actor.getName(), actor.getSurnames(), actor.getAge());

			if (!findActor.isPresent()) {
				Actor actor2 = new ActorBuilder().name(actor.getName(), actor.getSurnames()).age(actor.getAge())
						.build();
				actors.add(actor2);
				actorRepository.save(actor2);
			} else {
				actors.add(findActor.get());
			}
		});

		movie.setActors(actors);
		return movieRepository.save(movie);

	}

	public List<MovieYearTitleDTO> findTitleYear() {
		return TransformMovie.fromMovieListToMovieYearTitleDTOList(movieRepository.findAll());
	}

}