package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(crsf -> crsf.disable())
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/", "index.html").permitAll()
                        .requestMatchers("/public/endPoint").permitAll() //Servicio publico con todos los permisos
                        //.requestMatchers("security/delete/**").permitAll()
                        .requestMatchers(HttpMethod.GET).hasAnyAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.POST).hasAnyAuthority("ROLE_USER")
                        .requestMatchers(HttpMethod.DELETE).hasAnyAuthority("ROLE_DELETE")
                        .anyRequest().denyAll())
                        //.anyRequest().authenticated())
                        //.formLogin(form -> {});
                .httpBasic(b -> {});

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }    

    @Bean
    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){

        var user1 = User.builder()
                .username("damaya")
                .password(passwordEncoder.encode("damaya1234"))
                .authorities("ROLE_ADMIN")
                .build();

        var user2 = User.builder()
                .username("fernanda")
                .password(passwordEncoder.encode("fernanda1234"))
                .authorities("ROLE_USER")
                .build();

        var userDelete = User.builder()
                .username("Luis")
                .password(passwordEncoder.encode("luisDetele"))
                .authorities("ROLE_DELETE")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, userDelete);
    }

}