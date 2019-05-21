package pl.solutions.software.sokolik.bartosz.filter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import pl.solutions.software.sokolik.bartosz.domain.User;
import pl.solutions.software.sokolik.bartosz.service.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CustomSecurityFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Bearer";

    private final UserService userService;

    public CustomSecurityFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        Optional.ofNullable(req.getHeader(AUTHORIZATION_HEADER))
                .flatMap(this::getAuthenticationFor)
                .ifPresent(SecurityContextHolder.getContext()::setAuthentication);
        doFilter(req, res, chain);
    }

    private Optional<Authentication> getAuthenticationFor(String username) {
        return userService.getByUsername(username)
                .map(this::createAuthentication);
    }

    private Authentication createAuthentication(User user) {
        List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().toString()));
        return new UsernamePasswordAuthenticationToken(user, null, authorities);
    }
}
