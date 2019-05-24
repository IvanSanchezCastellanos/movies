package com.soprasteria.ivan.movies.service.dto.movie;

import java.io.Serializable;

public class MovieYearTitleDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String title;
	private String year;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}