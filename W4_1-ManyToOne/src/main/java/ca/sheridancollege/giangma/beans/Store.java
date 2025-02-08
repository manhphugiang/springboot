package ca.sheridancollege.giangma.beans;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@OneToMany(mappedBy="store")
	private List<Employee> employees;
	
	@ManyToMany
	@JoinTable(
		        name = "store_videogame",
		        joinColumns = @JoinColumn(name = "store_id"),
		        inverseJoinColumns = @JoinColumn(name = "videogame_id")
		    	)
	private List<Videogame> videogames;
}
	