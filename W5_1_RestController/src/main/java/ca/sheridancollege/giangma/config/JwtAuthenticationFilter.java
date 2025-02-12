package ca.sheridancollege.giangma.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import ca.sheridancollege.giangma.services.JMTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	private JMTService jwtService;
	private UserDetailsService userDetailsService;
	@Override
	protected void doFilterInternal(
			@NonNull HttpServletRequest request,
			@NonNull HttpServletResponse response,
			@NonNull FilterChain filterChain) throws IOException, ServletException {

		String authHeader = request.getHeader("Authorization");
		String jwt;
		String email;
		
		if(authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		jwt = authHeader.substring(7);
		email= jwtService.extractUsername(jwt);
		
		if(email != null && SecurityContextHolder.getContext().getAuthentication() == null ) {
			UserDetails userDetails = 
					this.userDetailsService.loadUserByUsername(email);
			
			if(jwtService.isTokenValid(jwt, userDetails)) {
				
				UsernamePasswordAuthenticationToken authToken = 
						new UsernamePasswordAuthenticationToken
						(userDetails, null, userDetails.getAuthorities() );
			authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
