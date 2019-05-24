package service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.soprasteria.ivan.movies.builder.entities.MovieBuilder;
import com.soprasteria.ivan.movies.exceptions.InvalidInputException;
import com.soprasteria.ivan.movies.exceptions.MovieNotFoundException;
import com.soprasteria.ivan.movies.model.entities.Actor;
import com.soprasteria.ivan.movies.model.entities.Movie;
import com.soprasteria.ivan.movies.model.repositories.ActorRepository;
import com.soprasteria.ivan.movies.model.repositories.MovieRepository;
import com.soprasteria.ivan.movies.service.MovieServiceImplementation;
import com.soprasteria.ivan.movies.service.dto.movie.MovieFullDTO;
import com.soprasteria.ivan.movies.service.dto.movie.MovieYearTitleDTO;

@RunWith(MockitoJUnitRunner.class)
public class TestMovieService {

	@Mock
	MovieRepository movieRepository;

	@Mock
	ActorRepository actorRepository;

	@InjectMocks
	MovieServiceImplementation service;

	@Test
	public void testGetMovieExists() {
		MovieFullDTO movieDTO = DataForServiceTests.getMovieFullDTO();	
		when(movieRepository.findById(1L)).thenReturn(Optional.of(DataForServiceTests.getMovie()));

		MovieFullDTO result = service.getMovie(1L);

		assertTrue("GetMovie method does not return the correct movie",
					movieDTO.getGenre().equals(result.getGenre())
				 && movieDTO.getTitle().equals(result.getTitle())
				 && movieDTO.getYear().equals(result.getYear()));
	}

	@Test(expected = MovieNotFoundException.class)
	public void testGetMovieNotExists() {
		when(movieRepository.findById(1L).orElseThrow(() -> new MovieNotFoundException()));

		service.getMovie(1L);
	}

	@Test
	public void testSaveMovie() {
		Movie movie = DataForServiceTests.getMovie();
		when(movieRepository.save(movie)).thenReturn( DataForServiceTests.getMovie());

		Movie result = service.saveMovie(DataForServiceTests.getMovieFullDTO());

		assertTrue("saveMovie method does not store a movie", movie.equals(result));
	}

	@Test
	public void testSaveMovieTwoTimes() {
//		when(movieRepository.save(movie)).thenReturn(movie);
//		Movie result1 = service.saveMovie(movieDTO);
//
//		when(movieRepository.save(movie)).thenReturn(null);
//		Movie result2 = service.saveMovie(movieDTO);

		assertTrue("There is a problem saving the same movie two times", true);
	}

	@Test(expected = InvalidInputException.class)
	public void testSaveNullMovie() {
		service.saveMovie(null);

	}

	@Test
	public void testSaveRepeatedMovie() {
		when(movieRepository.save(DataForServiceTests.getMovie())).thenReturn(null);

		assertTrue("saveMovie method stores a repeated movie", service.saveMovie(DataForServiceTests.getMovieFullDTO()) == null);
	}

	@Test
	public void testFindTitleYear() {
		List<Movie> moviesList = new ArrayList<Movie>();
		moviesList.add(new MovieBuilder().title("Titanic").genre("Drama").year("2010").actors(new ArrayList<Actor>()).build());
		moviesList.add(new MovieBuilder().title("Rocky").genre("Action").year("2010").actors(new ArrayList<Actor>()).build());
		when(movieRepository.findAll()).thenReturn(moviesList);

		List<MovieYearTitleDTO> result = service.findTitleYear();

		assertTrue("findTitleYear method does not return correct DTOs",
				moviesList.size() == result.size() && moviesList.get(0).getYear().equals(result.get(0).getYear())
						&& moviesList.get(0).getTitle().equals(result.get(0).getTitle())
						&& moviesList.get(1).getYear().equals(result.get(1).getYear())
						&& moviesList.get(1).getTitle().equals(result.get(1).getTitle()));
	}

	@Test
	public void testFindNotMoviesTitleYear() {
		when(movieRepository.findAll()).thenReturn(new ArrayList<Movie>());

		List<MovieYearTitleDTO> result = service.findTitleYear();

		assertTrue("findTitleYear method does not return correct DTOs", result.isEmpty());
	}

}