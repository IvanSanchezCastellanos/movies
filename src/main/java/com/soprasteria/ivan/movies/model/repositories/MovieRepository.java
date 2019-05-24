package com.soprasteria.ivan.movies.model.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.soprasteria.ivan.movies.model.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query("SELECT m FROM Movie m WHERE m.title = ?1 and m.genre = ?2 and m.year = ?3")
	Optional<Movie> findMovie(String title, String genre, String year);
}