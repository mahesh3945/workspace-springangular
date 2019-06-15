package hello;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentControllerTest 
{
	@InjectMocks
	private StudentController studentcontroller;
	@Mock
	private StudentRepository studentrepository;
	
	
	/*@Test
	public void studentAddTest()
	{
		StudentUser studentuser = new StudentUser();
		studentuser.setStudentId(11);
		studentuser.setStudentName("mahesh");
		studentuser.setStudentEmail("pmahesh@gmail.com");
		
		String actual= studentcontroller.addStudent(studentuser);
		String expected ="inserted";
		assertEquals(expected, actual);
	}*/
	@Test
	public void studentAllTest()
	{
		Iterable<StudentUser> actual = studentcontroller.getAllUsers();		
		long actualSize=actual.spliterator().getExactSizeIfKnown();
		assertEquals(0, actualSize);
	}
	@Test
	public void studentGetIdTest()
	{
		//String expected = studentcontroller.deleteStuent(sid);
		//String act
		
	}
	@Test
	public void studentDeleteTest()
	{
		
	}
	@Test
	public void studentUpdateTest()
	{
		
	}
	
}
