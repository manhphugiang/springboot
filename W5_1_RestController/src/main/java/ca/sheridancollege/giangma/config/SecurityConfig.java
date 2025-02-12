package ca.sheridancollege.giangma.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor

public class SecurityConfig {
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	private AuthenticationProvider authenticationProvider;

	@Bean
	public SecurityFilterChain securityFIlterChain(HttpSecurity http) throws Exception {

		return http
				.csrf(crsf -> crsf.disable())
				.cors(cors -> cors.disable())
				.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/api/auth/**").permitAll().anyRequest()
				.authenticated())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider)
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
}
