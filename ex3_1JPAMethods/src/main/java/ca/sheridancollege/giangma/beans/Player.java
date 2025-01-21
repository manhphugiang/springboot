
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
public class Player {
	@Id // must always be attached to an object 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@NonNull
	private String name;
	@NonNull
	private Integer guildPoint;
	@NonNull
	private String unitClass;

	
	@Transient
	private String[] unitClasses = {"Tank", "Melee DPS", "Ranged DPS", "Healer"};
}
