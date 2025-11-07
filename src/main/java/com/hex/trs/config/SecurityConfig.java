package com.hex.trs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
//    static{
//        System.out.println("My Security class Loads...");
//    }

    //I want to create a bean to define my users - InMemory Users
    @Bean
    public UserDetailsService users() {
        UserDetails user1 = User.builder()
                .username("customer1")
                .password("{noop}customer1")
                .roles("CUSTOMER")
                .build();
        UserDetails user2 = User.builder()
                .username("customer2")
                .password("{noop}customer2")
                .roles("CUSTOMER")
                .build();
        UserDetails user3 = User.builder()
                .username("executive1")
                .password("{noop}executive1")
                .roles("EXECUTIVE")
                .build();
        return new InMemoryUserDetailsManager(user1, user2, user3);
    }

    //I am defining the rules for API access : securedFilterChain

    @Bean
    public SecurityFilterChain securedFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/api/customer/sign-up").permitAll()

                        .requestMatchers(HttpMethod.GET, "/api/auth/public/hello").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/auth/user/hello").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/auth/customer/hello").hasAnyRole("CUSTOMER")
                        .requestMatchers(HttpMethod.GET, "/api/auth/executive/hello").hasAnyRole("EXECUTIVE")


                        .anyRequest().denyAll()
                );
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder getEncoder(){
        return new BCryptPasswordEncoder();
    }
}

/*
* 1. CORS <-- Cross Origin
* 2. CSRF <-- Cross Site Request Forgery (For POST APIs)
* */
