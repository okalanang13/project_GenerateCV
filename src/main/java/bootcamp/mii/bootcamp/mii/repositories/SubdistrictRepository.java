package bootcamp.mii.bootcamp.mii.repositories;


import bootcamp.mii.bootcamp.mii.entities.Subdistrict;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RR17
 */
@Repository
public interface SubdistrictRepository extends CrudRepository<Subdistrict, String>{
    
}
