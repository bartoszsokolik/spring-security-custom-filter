package pl.solutions.software.sokolik.bartosz.service;

import pl.solutions.software.sokolik.bartosz.controller.dto.UserDto;

public interface UserService {

    UserDto findByUsername(String username);
}
