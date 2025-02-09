package ca.sheridancollege.giangma.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Player {

	
	private Long id;
	private String name;
	private String playerClass;
	private int gamePlayed;
	private int gameWon;
	private int gameLost;
	private int point;

}
