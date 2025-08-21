/*
 * package com.example.bookapi.security;
 * 
 * import org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.Customizer; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfiguration; import
 * org.springframework.security.config.annotation.web.configurers.
 * HttpBasicConfigurer;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig extends
 * WebSecurityConfiguration { protected void configure(HttpSecurity http) throws
 * Exception { http.csrf(csrf -> csrf.disable()) .authorizeRequests(requests ->
 * requests .anyRequest().authenticated()) .httpBasic(withDefaults()); }
 * 
 * private Customizer<HttpBasicConfigurer<HttpSecurity>> withDefaults() { //
 * TODO Auto-generated method stub return null; } }
 */