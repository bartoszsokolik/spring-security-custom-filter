package pl.solutions.software.sokolik.bartosz.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static pl.solutions.software.sokolik.bartosz.configuration.Profiles.*;

@Profile("!" + PROD)
@Configuration
@EnableWebSecurity
public class DevSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .disable()
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable();
    }
}
