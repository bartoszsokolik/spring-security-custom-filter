package pl.solutions.software.sokolik.bartosz.service.impl;

import org.springframework.stereotype.Service;
import pl.solutions.software.sokolik.bartosz.assembler.UserAssembler;
import pl.solutions.software.sokolik.bartosz.controller.dto.UserDto;
import pl.solutions.software.sokolik.bartosz.exception.UserNotFoundException;
import pl.solutions.software.sokolik.bartosz.repository.UserRepository;
import pl.solutions.software.sokolik.bartosz.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserAssembler userAssembler;

    public UserServiceImpl(UserRepository userRepository, UserAssembler userAssembler) {
        this.userRepository = userRepository;
        this.userAssembler = userAssembler;
    }

    @Override
    public UserDto findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(userAssembler::fromDomain)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with username %s not found", username)));
    }
}
