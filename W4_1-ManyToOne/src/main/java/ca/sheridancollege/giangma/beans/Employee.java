package ca.sheridancollege.giangma.beans;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@Entity
@Document
@Builder
public class Employee {

	
	
//	@Id
//	@GeneratedValue(strategy= GenerationType.IDENTITY)
//	
	//private Integer id;
	@Id
	private String id;
	private String name;
	
	//many employees will be assigned to one store
	//Many to one does not have a mappedby option
//	@ManyToOne
//	@JoinTable(name="STORE_EMPLOYEE",
//		joinColumns=@JoinColumn(name="EMPLOYEE_ID"), 
//		inverseJoinColumns=@JoinColumn(name="STORE_ID"))
	
	
	 private Store store;
}





