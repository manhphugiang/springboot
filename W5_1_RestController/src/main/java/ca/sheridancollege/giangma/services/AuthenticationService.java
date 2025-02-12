package ca.sheridancollege.giangma.services;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import ca.sheridancollege.giangma.beans.Role;
import ca.sheridancollege.giangma.beans.User;
import ca.sheridancollege.giangma.models.AuthenticationRequest;
import ca.sheridancollege.giangma.models.AuthenticationResponse;
import ca.sheridancollege.giangma.repository.userRepository;

public class AuthenticationService {
	
	private PasswordEncoder passwordEncoder;
	private userRepository userRepo;
	private JMTService jwtService;
	private AuthenticationManager authManager;
	
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getEmail(), request.getPassword()));
		User user = userRepo.findByEmail(request.getEmail()).orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}
	
	
	public AuthenticationResponse register(AuthenticationRequest request) {
		User user = User.builder()
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(Role.USER)
				.build();
		userRepo.save(user);
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
		
	}
}
