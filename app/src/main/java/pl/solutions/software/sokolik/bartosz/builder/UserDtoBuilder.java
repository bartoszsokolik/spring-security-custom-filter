package pl.solutions.software.sokolik.bartosz.builder;

import pl.solutions.software.sokolik.bartosz.controller.dto.UserDto;
import pl.solutions.software.sokolik.bartosz.domain.UserRole;

public class UserDtoBuilder {

    private final UserDto dto;

    private UserDtoBuilder() {
        dto = new UserDto();
    }

    public static UserDtoBuilder builder() {
        return new UserDtoBuilder();
    }

    public UserDtoBuilder username(String username) {
        dto.setUsername(username);
        return this;
    }

    public UserDtoBuilder password(String password) {
        dto.setPassword(password);
        return this;
    }

    public UserDtoBuilder email(String email) {
        dto.setEmail(email);
        return this;
    }

    public UserDtoBuilder role(UserRole role) {
        dto.setRole(role);
        return this;
    }

    public UserDto build() {
        return dto;
    }
}
