package ca.sheridancollege.giangma.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.sheridancollege.giangma.models.AuthenticationRequest;
import ca.sheridancollege.giangma.models.AuthenticationResponse;

@Service
public class AuthenticationService {
	final private String EMAIL = "jon@123.ca";
	final private String PASSWORD = "1234";
	private String token = null;

	// Convert the AuthenticationRequest credentials to JSON
	private String convertToJson(final AuthenticationRequest userInfo) {
		String toReturn = null;
		try {
			toReturn = new ObjectMapper().writeValueAsString(userInfo);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return toReturn;
	}

	// Build an Authentication Request (.model) with credentials
	private String getAuthenticationBody() {
		AuthenticationRequest credentials = new AuthenticationRequest(EMAIL, PASSWORD);
		// return a JSONified version
		return convertToJson(credentials);
	}

	// If we have a token then set the token as part of the header
	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		if (token != null) {
			String authToken = "Bearer " + token;
			headers.set("Authorization", authToken);
		}
		return headers;
	}

	// A method to perform the authentication.
	private void authenticate(RestTemplate restTemplate) {
		// create headers and body specifying that it is
		// JSON request and include JSON details
		HttpHeaders authenticationHeaders = getHeaders();
		String authenticationBody = getAuthenticationBody();
		HttpEntity<String> authenticationEntity = new HttpEntity<String>(authenticationBody, authenticationHeaders);
		// Authenticate User and get JWT
		ResponseEntity<AuthenticationResponse> authenticationResponse = restTemplate.exchange(
				"http://localhost:50000/api/auth/authenticate", HttpMethod.POST, authenticationEntity,
				AuthenticationResponse.class);
		// if the authentication is successful, get the JWT token from the response
		if (authenticationResponse.getStatusCode().equals(HttpStatus.OK))
			token = authenticationResponse.getBody().getToken();
	}

	// Do a request based on the specified HTTP method and return
	// the result.
	public <T> ResponseEntity<T> standardRequest(RestTemplate restTemplate, String url, HttpMethod methodType,
			Class<T> returnType) {
		if (token == null)
			authenticate(restTemplate);
		HttpHeaders headers = getHeaders();
		HttpEntity<String> request = new HttpEntity<>("", headers);
		return (ResponseEntity<T>) restTemplate.exchange(url, methodType, request, returnType);
	}

	// Do a POST request based on the specified HTTP method and return
	// the result.
	public <T> ResponseEntity<T> postRequest(RestTemplate restTemplate, String url, Object objectToPost,
			Class<T> returnType) {
		if (token == null)
			authenticate(restTemplate);
		HttpHeaders headers = getHeaders();
		HttpEntity<Object> request = new HttpEntity<>(objectToPost, headers);
		return (ResponseEntity<T>) restTemplate.postForEntity(url, request, returnType);
	}

	// Do a PUT request based on the specified HTTP method and return
	// the result.
	public void putRequest(RestTemplate restTemplate, String url, Object objectToPut) {
		if (token == null)
			authenticate(restTemplate);
		HttpHeaders headers = getHeaders();
		HttpEntity<Object> request = new HttpEntity<>(objectToPut, headers);
		restTemplate.put(url, request, objectToPut);
	}
}
