package ca.sheridancollege.giangma.beans;

import jakarta.persistence.*;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Employee {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	//many employees will be assigned to one store
	//Many to one does not have a mappedby option
	@ManyToOne
	@JoinTable(name="STORE_EMPLOYEE",
	joinColumns=@JoinColumn(name="EMPLOYEE_ID"), 
	inverseJoinColumns=@JoinColumn(name="STORE_ID"))
	private Store store;

//	@DBRef
}





