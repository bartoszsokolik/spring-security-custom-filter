package pl.solutions.software.sokolik.bartosz.builder;

import pl.solutions.software.sokolik.bartosz.controller.dto.MovieDto;

public class MovieDtoBuilder {

    private final MovieDto dto;

    private MovieDtoBuilder() {
        dto = new MovieDto();
    }

    public static MovieDtoBuilder builder() {
        return new MovieDtoBuilder();
    }

    public MovieDtoBuilder title(String title) {
        dto.setTitle(title);
        return this;
    }

    public MovieDto build() {
        return dto;
    }
}
