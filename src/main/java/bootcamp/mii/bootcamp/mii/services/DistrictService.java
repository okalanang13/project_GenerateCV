package bootcamp.mii.bootcamp.mii.services;


import bootcamp.mii.bootcamp.mii.entities.District;
import bootcamp.mii.bootcamp.mii.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RR17
 */
@Repository
public class DistrictService {
    @Autowired
    private DistrictRepository districtImplement;
    
    
    public Iterable<District> findAllDistrict(){
        return districtImplement.findAll();
    }
}
