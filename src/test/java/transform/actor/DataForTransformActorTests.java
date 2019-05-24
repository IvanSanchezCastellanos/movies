package transform.actor;

import java.util.ArrayList;
import java.util.List;

import com.soprasteria.ivan.movies.builder.dto.actor.ActorFullDTOBuilder;
import com.soprasteria.ivan.movies.builder.entities.ActorBuilder;
import com.soprasteria.ivan.movies.model.entities.Actor;
import com.soprasteria.ivan.movies.service.dto.actor.ActorFullDTO;

public class DataForTransformActorTests {

	public static List<ActorFullDTO> getActorFullDTOList() {
		List<ActorFullDTO> actors = new ArrayList<ActorFullDTO>();
		actors.add(new ActorFullDTOBuilder().name("Silvester", "Stalone").age(24).build());
		actors.add(new ActorFullDTOBuilder().name("Ernesto", "Sevilla").age(43).build());
		return actors;
	}
	
	public static List<Actor> getActorList() {
		List<Actor> actors = new ArrayList<Actor>();
		actors.add(new ActorBuilder().name("Silvester", "Stalone").age(24).build());
		actors.add(new ActorBuilder().name("Ernesto", "Sevilla").age(43).build());
		return actors;
	}
}
