package finalproject.finalproject.repositories;

import finalproject.finalproject.entities.Degree;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RR17
 */
@Repository
public interface DegreeRepository extends CrudRepository<Degree, String>{
    
}
