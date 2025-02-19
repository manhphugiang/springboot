package ca.sheridancollege.giangma.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Item {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private Long id;
	private String name;
	private double price;
	@ManyToOne
	@JoinColumn(name="store_id")
	private Store store;
}
