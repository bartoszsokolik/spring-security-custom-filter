package pl.solutions.software.sokolik.bartosz.service;

import pl.solutions.software.sokolik.bartosz.controller.dto.MovieDto;

import java.util.List;

public interface MovieService {

    List<MovieDto> findAll();

    MovieDto findByTitle(String title);
}
