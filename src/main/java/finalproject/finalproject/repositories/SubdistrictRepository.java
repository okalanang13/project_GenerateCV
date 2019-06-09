package finalproject.finalproject.repositories;

import finalproject.finalproject.entities.Subdistrict;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RR17
 */
@Repository
public interface SubdistrictRepository extends CrudRepository<Subdistrict, String>{
    @Query(value = "select * from subdistrict where is_delete = 'false'", nativeQuery = true)
    List<Subdistrict> getAll();
}
