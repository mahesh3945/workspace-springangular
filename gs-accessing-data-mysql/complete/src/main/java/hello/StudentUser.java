package hello;

import javax.persistence.Entity;			
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class StudentUser
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	@Size(min=4,message="Name should be at least 4 characters")
	@Pattern(regexp="[a-zA-Z]+",message="student name must be a-z or A-Z")
	
	private String studentName;
	@Email(message="Invalid email format")
	private String studentEmail;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	
}
