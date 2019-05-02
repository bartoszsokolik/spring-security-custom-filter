package pl.solutions.software.sokolik.bartosz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.solutions.software.sokolik.bartosz.domain.Movie;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findByTitle(String title);
}
