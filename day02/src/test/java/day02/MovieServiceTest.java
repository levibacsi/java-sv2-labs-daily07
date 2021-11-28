package day02;

import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {
    @Test
    void testFillMovies(){
        MovieService movieService = new MovieService(Path.of("day02/src/test/resources/movies.csv"));

        assertEquals(5, movieService.getMovieList().size());
        assertEquals("Jaws", movieService.getMovieList().get(4).getTitle());
    }

    @Test
    void testFillMoviesFileNotFound(){
        IllegalStateException ise = assertThrows(IllegalStateException.class, ()-> new MovieService(Path.of("movies.txt")));

        assertEquals("Cannot read file.", ise.getMessage());
        assertEquals(NoSuchFileException.class, ise.getCause().getClass());
    }
}