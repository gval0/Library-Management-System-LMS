package com.library.lms.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
                .csrf(csrf -> csrf.ignoringRequestMatchers("/**"))
                .authorizeRequests(authorizeRequests ->
                    authorizeRequests
                    .anyRequest().authenticated()
            )
                .headers(headers -> headers.frameOptions(Customizer.withDefaults()).disable())
            .httpBasic(withDefaults());
//            .formLogin(withDefaults());
        return http.build();
    }
}
