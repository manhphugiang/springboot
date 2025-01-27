package ca.sheridancollege.giangma.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@Lob
	private String notes;
	
	@OneToOne
//	@JoinColumn
	@JoinTable(name= "STUDENT_ACCOUNT",
			joinColumns = @JoinColumn(name="STUDENT_ID"),
			inverseJoinColumns=@JoinColumn(name="ACCOUNT_ID"))
	private Account account;
}
