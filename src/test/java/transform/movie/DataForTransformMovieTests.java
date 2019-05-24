package transform.movie;

import java.util.ArrayList;
import java.util.List;

import com.soprasteria.ivan.movies.builder.dto.actor.ActorFullDTOBuilder;
import com.soprasteria.ivan.movies.builder.dto.movie.MovieFullDTOBuilder;
import com.soprasteria.ivan.movies.service.dto.actor.ActorFullDTO;
import com.soprasteria.ivan.movies.service.dto.movie.MovieFullDTO;

public class DataForTransformMovieTests {

	public static MovieFullDTO getMovieDTO() {
		List<ActorFullDTO> actorsListDTO = new ArrayList<ActorFullDTO>();
		actorsListDTO.add(new ActorFullDTOBuilder().name("Silvester", "Stalone").age(24).build());
		actorsListDTO.add(new ActorFullDTOBuilder().name("Leonardo", "Dicaprio").age(18).build());
		return new MovieFullDTOBuilder().title("Titanic").year("2010").genre("Drama").actors(actorsListDTO).build();
	}

}