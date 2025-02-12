package ca.sheridancollege.giangma.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationResponse {
	private String token;
}
