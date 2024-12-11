package com.example.carCrud.config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
  public   SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http.cors(Customizer.withDefaults());
      http.csrf(Customizer.withDefaults());
      http.authorizeHttpRequests(
              auth->auth
                      .requestMatchers("/cars").hasRole("ADMIN")
                      .requestMatchers("/login").permitAll()



      );
      return http.build();

  }

  @Bean
    InMemoryUserDetailsManager userDetailsManager() {



     UserDetails admin = User.withDefaultPasswordEncoder().password("one").username("kamau").roles("ADMIN").build();
     UserDetails user= User.withDefaultPasswordEncoder().password("one").username("user").roles("USER").build();

     return new InMemoryUserDetailsManager(user, admin);

  }

}

