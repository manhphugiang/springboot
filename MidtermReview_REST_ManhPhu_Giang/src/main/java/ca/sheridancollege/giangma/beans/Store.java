package ca.sheridancollege.giangma.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Store {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private Long id;
	private String name;
	@JsonIgnore
	@OneToMany(mappedBy="store")
	private List<Item> items;
}
