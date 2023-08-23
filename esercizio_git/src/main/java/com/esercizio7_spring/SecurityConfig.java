package com.esercizio7_spring;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

	// @Autowired
	// JwtAuthFilter jwtFilter;
	/*
	 * @Bean SecurityFilterChain securityFilterChain(HttpSecurity http) throws
	 * Exception { http.cors(c -> c.disable()); http.csrf(c -> c.disable());
	 * 
	 * // Se vogliamo utilizzare JWT dobbiamo disabilitare anche le sessioni
	 * http.sessionManagement(session ->
	 * session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	 * 
	 * http.authorizeHttpRequests(auth ->
	 * auth.requestMatchers("/dispositivi/**").permitAll());
	 * http.authorizeHttpRequests(auth ->
	 * auth.requestMatchers("/dipendenti/**").permitAll());
	 * http.authorizeHttpRequests(auth ->
	 * auth.requestMatchers("/auth/**").permitAll());
	 * http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	 * 
	 * return http.build(); }
	 */
}
