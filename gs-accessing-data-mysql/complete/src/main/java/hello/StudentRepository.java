package hello;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentUser, Integer>  {

}
