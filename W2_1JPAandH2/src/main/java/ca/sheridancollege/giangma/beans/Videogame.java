package ca.sheridancollege.giangma.beans;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Videogame {
	@Id // must always be attached to an object 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@NonNull
	private String title;
	@NonNull
	private Integer isbn;
	@NonNull
	private String genre;
	@NonNull
	private Double price;
	
	@Transient
	private String[] genres = {"RPG", "Stragegy", "Arcade", "Shooter", "Horror"};
}
