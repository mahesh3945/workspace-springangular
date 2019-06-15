package hello;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController  
public class StudentController  {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private StudentRepository studentrepository;		
	@PostMapping(path="/Student",consumes="application/json")
	public ResponseEntity<String> addStudent(@Valid @RequestBody StudentUser studentuser,BindingResult bindingResult)
	{
		String messages="";
		System.out.println("***************");		
		if(bindingResult.hasErrors()) {
			
					List<FieldError> fieldErrors=bindingResult.getFieldErrors();
					
					for (FieldError fieldError : fieldErrors) {						
						messages=messages.concat(fieldError.getDefaultMessage()+"\n");
						
					}
			return new ResponseEntity<String>(messages,HttpStatus.BAD_REQUEST);
		}	
		else {
		studentrepository.save(studentuser);		
		return  new ResponseEntity<String>("Inserted", HttpStatus.OK);	
		}
	}
	
	@GetMapping(path="/student")
	public @ResponseBody Iterable<StudentUser> getAllUsers() {
		// This returns a JSON or XML with the users
		return studentrepository.findAll();
	}
	
	@GetMapping(path="/student/{studentid}")
	public @ResponseBody StudentUser getStudentDetails(@PathVariable("studentid") int sid)
	{
		return studentrepository.findById(sid).get();
	}
	
	@DeleteMapping(path="/student/{studentid}")
	public @ResponseBody String deleteStuent(@PathVariable("studentid") int sid)
	{
		studentrepository.deleteById(sid);
		return "record deleted";
	}
	@PutMapping(path="/student")
	public @ResponseBody String updateStudent(@RequestBody StudentUser studentuser)
	{
		try {
		StudentUser user=studentrepository.findById(studentuser.getStudentId()).get();
		if(user!=null) {		
			studentrepository.save(studentuser);
			}
		return "updated successfully";
		
		}
		catch(Exception e) {		
			return "no record found";
		}
		}
}
