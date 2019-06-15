package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
private EmployeeRepository EmployeeRepository;		
@PostMapping(path="/employee",consumes="application/json")
public @ResponseBody String addemployee(@RequestBody EmployeeUser EmployeeUser)
{
System.out.println("***************");
EmployeeRepository.save(EmployeeUser);		
return "inserted";		
}

@GetMapping(path="/employee")
public @ResponseBody Iterable<EmployeeUser> getAllUsers() {
// This returns a JSON or XML with the users
return EmployeeRepository.findAll();
}

@GetMapping(path="/employee/{employeeid}")
public @ResponseBody EmployeeUser getemployeeDetails(@PathVariable("employeeid") int sid)
{
return EmployeeRepository.findById(sid).get();
}

@DeleteMapping(path="/employee/{employeeid}")
public @ResponseBody String deleteStuent(@PathVariable("employeeid") int sid)
{
EmployeeRepository.deleteById(sid);
return "record deleted";
}
@PutMapping(path="/employee")
public @ResponseBody String updateemployee(@RequestBody EmployeeUser EmployeeUser)
{
try {
EmployeeUser user=EmployeeRepository.findById(EmployeeUser.getEmpId()).get();
if(user!=null) {		
	EmployeeRepository.save(EmployeeUser);
	}
return "updated successfully";

}
catch(Exception e) {		
	return "no record found";
}
}
}