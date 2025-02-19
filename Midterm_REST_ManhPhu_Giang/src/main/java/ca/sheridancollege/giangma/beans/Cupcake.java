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
public class Cupcake {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private Long id;
	private String cupcakeName;
	

	private double price;
	private int quantity;
	@ManyToOne
	@JoinColumn(name="firefighter_id")
	private Firefighter employeeName;
}
