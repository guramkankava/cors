package com.github.guramkankava.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Component
public class WebConfig extends WebSecurityConfigurerAdapter {

    private static final CorsConfigurationSource corsConfigurationSource = request -> {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(List.of("http://localhost:8080", "http://127.0.0.1:8080"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "OPTIONS"));
        corsConfiguration.setAllowedHeaders(List.of("Authorization"));
        return corsConfiguration;
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and().authorizeRequests().anyRequest().authenticated()
                .and().csrf().disable()
                .cors(c -> c.configurationSource(corsConfigurationSource))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("guram")
                .password("password")
                .authorities("read")
        .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

}
