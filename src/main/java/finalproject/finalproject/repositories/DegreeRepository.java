package finalproject.finalproject.repositories;

import finalproject.finalproject.entities.Degree;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RR17
 */
@Repository
public interface DegreeRepository extends CrudRepository<Degree, String>{
    @Query(value = "select * from degree where is_delete = 'false'", nativeQuery = true)
    List<Degree> getAll();
}
