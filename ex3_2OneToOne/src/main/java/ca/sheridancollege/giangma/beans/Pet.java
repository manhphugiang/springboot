package ca.sheridancollege.giangma.beans;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String species;
	
	@OneToOne
	@JoinColumn(name="guest_id")
	private Guest guest;
}
