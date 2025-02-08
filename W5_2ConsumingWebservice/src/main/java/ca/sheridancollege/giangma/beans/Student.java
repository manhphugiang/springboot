package ca.sheridancollege.giangma.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Student {

	
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
