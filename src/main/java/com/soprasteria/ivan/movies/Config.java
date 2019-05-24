package com.soprasteria.ivan.movies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.soprasteria.ivan.movies.builder.entities.ActorBuilder;
import com.soprasteria.ivan.movies.builder.entities.MovieBuilder;
import com.soprasteria.ivan.movies.model.entities.Actor;
import com.soprasteria.ivan.movies.model.repositories.ActorRepository;
import com.soprasteria.ivan.movies.model.repositories.MovieRepository;

@Configuration
public class Config {

	@Bean
	public CommandLineRunner initializeDatabase(MovieRepository moviesRepository, ActorRepository actorRepository) {
		return args -> {

			Actor actor1 = new ActorBuilder().name("Silvester", "Stalone").age(24).build();
			Actor actor2 = new ActorBuilder().name("Bradd", "Pitt").age(40).build();
			Actor actor3 = new ActorBuilder().name("Ernesto", "Sevilla").age(31).build();
			Actor actor4 = new ActorBuilder().name("Santiago", "Sevilla").age(53).build();
			Actor actor5 = new ActorBuilder().name("Chris", "Evans").age(36).build();

			actorRepository.save(actor1);
			actorRepository.save(actor2);
			actorRepository.save(actor3);
			actorRepository.save(actor4);
			actorRepository.save(actor5);

			List<Actor> actors1 = new ArrayList<Actor>();
			actors1.add(actor1);
			actors1.add(actor2);
			actors1.add(actor3);

			List<Actor> actors2 = new ArrayList<Actor>();
			actors2.add(actor4);
			actors2.add(actor5);

			moviesRepository.save(new MovieBuilder().title("Insidious").genre("Terror").year("2010").actors(actors1).build());
			moviesRepository.save(new MovieBuilder().title("Caperucita Roja").genre("Drama").year("2004").actors(actors2).build());

		};
	}
}