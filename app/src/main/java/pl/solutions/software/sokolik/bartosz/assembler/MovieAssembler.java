package pl.solutions.software.sokolik.bartosz.assembler;

import org.springframework.stereotype.Component;
import pl.solutions.software.sokolik.bartosz.builder.MovieBuilder;
import pl.solutions.software.sokolik.bartosz.builder.MovieDtoBuilder;
import pl.solutions.software.sokolik.bartosz.controller.dto.MovieDto;
import pl.solutions.software.sokolik.bartosz.domain.Movie;

@Component
public class MovieAssembler {

    public Movie fromDto(MovieDto dto) {
        return MovieBuilder.builder()
                .title(dto.getTitle())
                .build();
    }

    public MovieDto fromDomain(Movie movie) {
        return MovieDtoBuilder.builder()
                .title(movie.getTitle())
                .build();
    }
}
