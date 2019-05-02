package pl.solutions.software.sokolik.bartosz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.solutions.software.sokolik.bartosz.authorization.LoggedInAuthorization;
import pl.solutions.software.sokolik.bartosz.authorization.UserAuthorization;
import pl.solutions.software.sokolik.bartosz.controller.dto.MovieDto;
import pl.solutions.software.sokolik.bartosz.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @UserAuthorization
    public List<MovieDto> getMovies() {
        return movieService.findAll();
    }

    @GetMapping("/{title}")
    @LoggedInAuthorization
    public ResponseEntity<MovieDto> getMovie(@PathVariable String title) {
        return new ResponseEntity<>(movieService.findByTitle(title), HttpStatus.OK);
    }
}
