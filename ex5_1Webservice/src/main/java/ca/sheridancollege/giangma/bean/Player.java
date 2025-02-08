package ca.sheridancollege.giangma.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Player {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private Long id;
	private String name;
	private String playerClass;
	private int gamePlayed;
	private int gameWon;
	private int gameLost;
	private int point;
}
