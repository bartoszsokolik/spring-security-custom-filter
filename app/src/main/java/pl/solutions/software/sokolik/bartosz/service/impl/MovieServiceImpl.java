package pl.solutions.software.sokolik.bartosz.service.impl;

import org.springframework.stereotype.Service;
import pl.solutions.software.sokolik.bartosz.assembler.MovieAssembler;
import pl.solutions.software.sokolik.bartosz.controller.dto.MovieDto;
import pl.solutions.software.sokolik.bartosz.exception.MovieNotFoundException;
import pl.solutions.software.sokolik.bartosz.repository.MovieRepository;
import pl.solutions.software.sokolik.bartosz.service.MovieService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieAssembler movieAssembler;

    public MovieServiceImpl(MovieRepository movieRepository, MovieAssembler movieAssembler) {
        this.movieRepository = movieRepository;
        this.movieAssembler = movieAssembler;
    }

    @Override
    public List<MovieDto> findAll() {
        return movieRepository.findAll()
                .stream()
                .map(movieAssembler::fromDomain)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDto findByTitle(String title) {
        return movieRepository.findByTitle(title)
                .map(movieAssembler::fromDomain)
                .orElseThrow(() -> new MovieNotFoundException(String.format("Movie with title %s not found", title)));
    }
}