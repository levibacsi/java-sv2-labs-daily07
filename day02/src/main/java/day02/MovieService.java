package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MovieService {
    private List<Movie> movieList = new ArrayList<>();

    public List<Movie> getMovieList() {
        return movieList;
    }

    public MovieService(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            fillListWithMovies(lines);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file.", ioe);
        }
    }

    private void fillListWithMovies(List<String> lines) {
        for (String s: lines){
            String[] tmp = s.split(";");
            movieList.add(new Movie(tmp[0], Integer.parseInt(tmp[1]), tmp[2]));
        }
    }
}
