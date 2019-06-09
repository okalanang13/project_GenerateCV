package finalproject.finalproject.repositories;

import finalproject.finalproject.entities.College;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RR17
 */
@Repository
public interface CollegeRepository extends CrudRepository<College, String>{
    @Query(value = "select * from college where is_delete = 'false'", nativeQuery = true)
    List<College> getAll();
}
