package ca.sheridancollege.giangma.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.giangma.models.AuthenticationRequest;
import ca.sheridancollege.giangma.models.AuthenticationResponse;
import ca.sheridancollege.giangma.services.AuthenticationService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {
	
	private AuthenticationService authenticationService;
	
	@PostMapping(value = {"/register"}, consumes = "application/json")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request){
		return ResponseEntity.ok(authenticationService.register(request));
	}
	
	@PostMapping(value = {"/authenticate"}, consumes = "application/json")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
		return ResponseEntity.ok(authenticationService.authenticate(request));
	}
}
