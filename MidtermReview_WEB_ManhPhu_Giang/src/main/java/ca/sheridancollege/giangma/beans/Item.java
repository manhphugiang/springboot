package ca.sheridancollege.giangma.beans;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Item {
	private Long id;
	private String name;
	private double price;
	private Store store;
}
