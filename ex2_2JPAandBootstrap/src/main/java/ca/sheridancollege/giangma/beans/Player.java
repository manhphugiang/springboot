package ca.sheridancollege.giangma.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Data
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NonNull
	private String name;
	@NonNull
	private Integer kills;
	@NonNull
	private Integer Deaths;
	@NonNull
	private Integer matches;
	@NonNull
	private Integer points;
}
