package pl.solutions.software.sokolik.bartosz.service;

import pl.solutions.software.sokolik.bartosz.controller.dto.UserDto;
import pl.solutions.software.sokolik.bartosz.domain.User;

import java.util.Optional;

public interface UserService {

    UserDto findByUsername(String username);

    Optional<User> getByUsername(String username);
}
