package pl.solutions.software.sokolik.bartosz.authorization;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasRole(T(pl.solutions.software.sokolik.bartosz.domain.UserRole).ROLE_USER)")
public @interface UserAuthorization {
}
