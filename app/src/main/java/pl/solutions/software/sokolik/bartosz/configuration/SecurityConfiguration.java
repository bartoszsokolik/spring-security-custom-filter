package pl.solutions.software.sokolik.bartosz.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pl.solutions.software.sokolik.bartosz.filter.CustomSecurityFilter;

import static pl.solutions.software.sokolik.bartosz.configuration.Profiles.PROD;

@Profile(PROD)
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public SecurityConfiguration(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/h2-console/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilterBefore(customSecurityFilter(), UsernamePasswordAuthenticationFilter.class)
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .httpBasic()
                .disable();
    }

    @Bean
    public CustomSecurityFilter customSecurityFilter() {
        return new CustomSecurityFilter(userDetailsService);
    }
}