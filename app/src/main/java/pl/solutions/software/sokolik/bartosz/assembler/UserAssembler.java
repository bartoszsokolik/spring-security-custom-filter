package pl.solutions.software.sokolik.bartosz.assembler;

import org.springframework.stereotype.Component;
import pl.solutions.software.sokolik.bartosz.builder.UserBuilder;
import pl.solutions.software.sokolik.bartosz.builder.UserDtoBuilder;
import pl.solutions.software.sokolik.bartosz.controller.dto.UserDto;
import pl.solutions.software.sokolik.bartosz.domain.User;

@Component
public class UserAssembler {

    public User fromDto(UserDto dto) {
        return UserBuilder.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .role(dto.getRole())
                .build();
    }

    public UserDto fromDomain(User user) {
        return UserDtoBuilder.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
