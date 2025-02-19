package ca.sheridancollege.giangma.beans;

import java.util.List;

import ca.sheridancollege.giangma.controller.firefighterEmployeeController;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Firefighter {
	private Long id;
	private String name;
	
	private List<Cupcake> cupcakes;
}
