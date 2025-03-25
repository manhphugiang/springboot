package ca.sheridancollege.giangma.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/", "/oauth/**").permitAll().anyRequest().authenticated())
				.oauth2Login(oauth2 -> oauth2.defaultSuccessUrl("/secure"))
				.logout(logout -> logout.clearAuthentication(true).logoutSuccessUrl("/").invalidateHttpSession(true))
				.build();
	}

}
