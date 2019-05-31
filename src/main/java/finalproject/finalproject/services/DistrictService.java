package finalproject.finalproject.services;

import finalproject.finalproject.entities.District;
import finalproject.finalproject.repositories.DistrictRepository;
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
