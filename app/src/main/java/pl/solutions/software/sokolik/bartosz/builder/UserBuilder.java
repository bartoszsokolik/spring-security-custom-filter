package pl.solutions.software.sokolik.bartosz.builder;

import pl.solutions.software.sokolik.bartosz.domain.User;
import pl.solutions.software.sokolik.bartosz.domain.UserRole;

public class UserBuilder {

    private final User user;

    private UserBuilder() {
        user = new User();
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public UserBuilder username(String username) {
        user.setUsername(username);
        return this;
    }

    public UserBuilder password(String password) {
        user.setPassword(password);
        return this;
    }

    public UserBuilder email(String email) {
        user.setEmail(email);
        return this;
    }

    public UserBuilder role(UserRole role) {
        user.setRole(role);
        return this;
    }

    public User build() {
        return user;
    }
}
