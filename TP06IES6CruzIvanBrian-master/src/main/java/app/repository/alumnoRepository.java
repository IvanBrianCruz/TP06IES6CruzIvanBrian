package app.repository;

import org.springframework.stereotype.Repository;
import app.models.Alumno;



import org.springframework.data.repository.CrudRepository;



@Repository 
public interface alumnoRepository extends CrudRepository <Alumno, String > {

	

}
