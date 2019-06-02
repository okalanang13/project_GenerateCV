package finalproject.finalproject.repositories;

import finalproject.finalproject.entities.College;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RR17
 */
@Repository
public interface CollegeRepository extends CrudRepository<College, String>{
    
}
