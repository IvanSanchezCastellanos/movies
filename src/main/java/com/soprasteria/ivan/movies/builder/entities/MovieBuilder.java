package com.soprasteria.ivan.movies.builder.entities;

import java.util.List;

import com.soprasteria.ivan.movies.model.entities.Actor;
import com.soprasteria.ivan.movies.model.entities.Movie;

public class MovieBuilder {

	private String title;
	private String genre;
	private String year;
	private List<Actor> actors;

	public MovieBuilder title(String title) {
		this.title = title;
		return this;
	}

	public MovieBuilder genre(String genre) {
		this.genre = genre;
		return this;
	}

	public MovieBuilder year(String year) {
		this.year = year;
		return this;
	}

	public MovieBuilder actors(List<Actor> actors) {
		this.actors = actors;
		return this;
	}

	public Movie build() {
		Movie movie = new Movie();
		movie.setTitle(title);
		movie.setGenre(genre);
		movie.setYear(year);
		movie.setActors(actors);
		return movie;
	}

	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public String getYear() {
		return year;
	}

	public List<Actor> getActors() {
		return actors;
	}

}