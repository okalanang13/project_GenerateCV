package finalproject.finalproject.repositories;

import finalproject.finalproject.entities.Province;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RR17
 */
@Repository
public interface ProvinceRepository extends CrudRepository<Province, String> {

    @Query(value = "select * from province where is_delete = 'false'", nativeQuery = true)
    List<Province> findAll();
}
