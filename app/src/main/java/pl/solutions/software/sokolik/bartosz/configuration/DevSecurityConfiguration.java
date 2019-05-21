package pl.solutions.software.sokolik.bartosz.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.solutions.software.sokolik.bartosz.service.UserService;

import static pl.solutions.software.sokolik.bartosz.configuration.Profiles.PROD;

@Profile("!" + PROD)
@Configuration
@EnableWebSecurity
public class DevSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    public DevSecurityConfiguration(UserService userService) {
        this.userService = userService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .disable()
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable();

        http.authorizeRequests()
                .anyRequest()
                .permitAll();
    }
}
