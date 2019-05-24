package com.soprasteria.ivan.movies.builder.dto.movie;

import com.soprasteria.ivan.movies.service.dto.movie.MovieYearTitleDTO;

public class MovieYearTitleDTOBuilder {

	private String title;
	private String year;

	public MovieYearTitleDTOBuilder title(String title) {
		this.title = title;
		return this;
	}

	public MovieYearTitleDTOBuilder year(String year) {
		this.year = year;
		return this;
	}

	public MovieYearTitleDTO build() {
		MovieYearTitleDTO dto = new MovieYearTitleDTO();
		dto.setTitle(title);
		dto.setYear(year);
		return dto;
	}

	public String getTitle() {
		return title;
	}

	public String getYear() {
		return year;
	}

}