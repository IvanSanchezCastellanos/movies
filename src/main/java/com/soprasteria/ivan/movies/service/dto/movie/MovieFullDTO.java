package com.soprasteria.ivan.movies.service.dto.movie;

import java.util.List;

import com.soprasteria.ivan.movies.service.dto.actor.ActorFullDTO;

public class MovieFullDTO extends MovieYearTitleDTO {

	private static final long serialVersionUID = 1L;
	private String genre;
	private List<ActorFullDTO> actors;

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<ActorFullDTO> getActors() {
		return actors;
	}

	public void setActors(List<ActorFullDTO> actors) {
		this.actors = actors;
	}

}