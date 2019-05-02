package pl.solutions.software.sokolik.bartosz.builder;

import pl.solutions.software.sokolik.bartosz.domain.Movie;

public class MovieBuilder {

    private final Movie movie;

    private MovieBuilder() {
        movie = new Movie();
    }

    public static MovieBuilder builder() {
        return new MovieBuilder();
    }

    public MovieBuilder title(String title) {
        movie.setTitle(title);
        return this;
    }

    public Movie build() {
        return movie;
    }
}
