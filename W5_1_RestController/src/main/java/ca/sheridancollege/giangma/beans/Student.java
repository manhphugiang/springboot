package ca.sheridancollege.giangma.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Student {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private Long id;
	private String name;
	private int grade;
	private String letterGrade;
	
	public void setGrade(int grade) {
		if(grade < 0)
			grade = 0;
		if(grade > 100)
			grade = 100;
		this.grade=grade;
	}
	
	public void assignLetterGrade() {
		if(grade >=80)
			letterGrade = "A";
		else if (grade >= 70)
			letterGrade = "B";
		else if (grade >= 60)
			letterGrade = "C";
		else if (grade >= 50)
			letterGrade = "D";
		else
			letterGrade = "F";
	}
}
