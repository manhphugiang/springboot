package ca.sheridancollege.giangma.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Cupcake {
	private Long id;
	private String cupcakeName;
	

	private double price;
	private int quantity;

	private Firefighter employeeName;
}
