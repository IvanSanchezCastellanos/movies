package com.soprasteria.ivan.movies.model.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.soprasteria.ivan.movies.model.entities.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long> {

	@Query("SELECT a FROM Actor a WHERE a.name = ?1 and a.surnames = ?2 and a.age = ?3")
	Optional<Actor> findActor(String name, String surnames, Integer age);
}