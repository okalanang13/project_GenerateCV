package finalproject.finalproject.repositories;

import finalproject.finalproject.entities.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RR17
 */
@Repository
public interface ProvinceRepository extends CrudRepository<Province, String>{
    
}
