package ca.sheridancollege.giangma.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Shirt {
	
	private Long id;
	private String name;
	private Double price;
	private int quantity;
	private String employeeName;
}
