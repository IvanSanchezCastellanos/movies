package transform.movie;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.soprasteria.ivan.movies.builder.dto.movie.MovieYearTitleDTOBuilder;
import com.soprasteria.ivan.movies.builder.entities.ActorBuilder;
import com.soprasteria.ivan.movies.builder.entities.MovieBuilder;
import com.soprasteria.ivan.movies.model.entities.Actor;
import com.soprasteria.ivan.movies.model.entities.Movie;
import com.soprasteria.ivan.movies.service.dto.movie.MovieFullDTO;
import com.soprasteria.ivan.movies.service.dto.movie.MovieYearTitleDTO;
import com.soprasteria.ivan.movies.service.dto.movie.TransformMovie;

@RunWith(MockitoJUnitRunner.class)
public class TestTransformMovie {

	static final String movieTitle = "Titanic";

	static final String movieYear = "2010";

	static final String movieGenre = "Drama";

	@Test
	public void testFromMovieListToMovieYearTitleDTOList() {
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(
				new MovieBuilder().title("Titanic").genre("Drama").year("2010").actors(new ArrayList<Actor>()).build());
		movies.add(
				new MovieBuilder().title("Rocky").genre("Action").year("2004").actors(new ArrayList<Actor>()).build());

		MovieYearTitleDTO movieDTO = new MovieYearTitleDTOBuilder().title("Rocky").year("2004").build();

		List<MovieYearTitleDTO> listResult = TransformMovie.fromMovieListToMovieYearTitleDTOList(movies);

		assertTrue("Transform from movie to movie/year dto list not correct",
				movieTitle.equals(listResult.get(0).getTitle()) && movieYear.equals(listResult.get(0).getYear())
						&& (movieDTO.getTitle().equals(listResult.get(1).getTitle())
								&& movieDTO.getYear().equals(listResult.get(1).getYear())));

	}

	@Test
	public void testFromNullMovieListToMovieYearTitleDTOList() {

		assertTrue("Transform from movie to movie/year dto list not correct",
				TransformMovie.fromMovieListToMovieYearTitleDTOList(null) == null);

	}

	@Test
	public void testFromMovieToMovieFullDTO() {
		ArrayList<Actor> actorsList = new ArrayList<Actor>();
		actorsList.add(new ActorBuilder().name("silvester", "Stalone").age(24).build());
		actorsList.add(new ActorBuilder().name("Leonardo", "Dicaprio").age(18).build());
		Movie movie = new MovieBuilder().title("Titanic").genre("Drama").year("2010").actors(actorsList).build();

		MovieFullDTO result = TransformMovie.fromMovieToMovieFullDTO(movie);

		boolean equal = false;
		if (result.getYear().equals(movieYear) && result.getGenre().equals(movieGenre)
				&& result.getTitle().equals(movieTitle)) {
			equal = true;

		}
		assertTrue("Transform from movie to movieDTO not correct", equal);

	}

	@Test
	public void testFromNullMovieToMovieFullDTO() {
		assertTrue("Transform from null movie to movie/year dto list not correct",
				TransformMovie.fromMovieListToMovieYearTitleDTOList(null) == null);

	}

	@Test
	public void testFromMovieDTOToMovie() {

		Movie result = TransformMovie.fromMovieDTOToMovie(DataForTransformMovieTests.getMovieDTO());

		boolean equal = false;
		if (result.getYear().equals(movieYear) && result.getGenre().equals(movieGenre)
				&& result.getTitle().equals(movieTitle)) {
			equal = true;
		}
		assertTrue("Transform from movieDTO to movie not correct", equal);

	}

	@Test
	public void testFromNullMovieDTOToMovie() {
		assertTrue("Transform from null movieDTO to movie not correct",
				TransformMovie.fromMovieDTOToMovie(null) == null);

	}
	
	@Test
	public void fromNullMovieListToMovieYearTitleDTOList() {
		assertTrue("Transform from null movie list to movie year/title is not correct",
				TransformMovie.fromMovieListToMovieYearTitleDTOList(null) == null);
	}
	
	@Test
	public void fromNullMovieToMovieFullDTO() {
		assertTrue("Transform from null movie to movie full DTO is not correct", TransformMovie.fromMovieToMovieFullDTO(null) == null);
	}
}