package hello;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository  extends CrudRepository<EmployeeUser, Integer>{

}
