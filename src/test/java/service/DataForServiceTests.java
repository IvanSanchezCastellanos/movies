package service;
import java.util.ArrayList;
import java.util.List;

import com.soprasteria.ivan.movies.builder.dto.movie.MovieFullDTOBuilder;
import com.soprasteria.ivan.movies.builder.entities.ActorBuilder;
import com.soprasteria.ivan.movies.builder.entities.MovieBuilder;
import com.soprasteria.ivan.movies.model.entities.Actor;
import com.soprasteria.ivan.movies.model.entities.Movie;
import com.soprasteria.ivan.movies.service.dto.actor.TransformActor;
import com.soprasteria.ivan.movies.service.dto.movie.MovieFullDTO;

public class DataForServiceTests {

	public static Movie getMovie() {
		return new MovieBuilder().title("Titanic").genre("Drama").year("2010").actors(new ArrayList<Actor>()).build();
	}
	
	public static List<Actor> getListOfActors() {
		List<Actor> actors = new ArrayList<Actor>();
		actors.add(new ActorBuilder().name("Silvester", "Stalone").age(24).build());
		actors.add(new ActorBuilder().name("Ernesto", "Sevilla").age(32).build());
		return actors;
	}
	
	public static MovieFullDTO getMovieFullDTO() {
		return new MovieFullDTOBuilder().title("Titanic").year("2010").genre("Drama")
				.actors(TransformActor.fromActorListToActorFullDTOList(new ArrayList<Actor>())).build();
	}
}
