package com.soprasteria.ivan.movies.builder.dto.movie;

import java.util.List;

import com.soprasteria.ivan.movies.service.dto.actor.ActorFullDTO;
import com.soprasteria.ivan.movies.service.dto.movie.MovieFullDTO;

public class MovieFullDTOBuilder extends MovieYearTitleDTOBuilder {

	private String genre;
	private List<ActorFullDTO> actors;
	private String title;
	private String year;

	public MovieFullDTOBuilder genre(String genre) {
		this.genre = genre;
		return this;
	}

	public MovieFullDTOBuilder actors(List<ActorFullDTO> actors) {
		this.actors = actors;
		return this;
	}

	public MovieFullDTOBuilder title(String title) {
		this.title = title;
		return this;
	}

	public MovieFullDTOBuilder year(String year) {
		this.year = year;
		return this;
	}

	public MovieFullDTO build() {
		MovieFullDTO dto = new MovieFullDTO();
		dto.setActors(actors);
		dto.setGenre(genre);
		dto.setTitle(title);
		dto.setYear(year);
		return dto;
	}

	public String getGenre() {
		return genre;
	}

	public List<ActorFullDTO> getActors() {
		return actors;
	}

	public String getTitle() {
		return title;
	}

	public String getYear() {
		return year;
	}

}