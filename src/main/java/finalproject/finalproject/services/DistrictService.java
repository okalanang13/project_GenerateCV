package finalproject.finalproject.services;

import finalproject.finalproject.entities.District;
import finalproject.finalproject.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RR17
 */
@Service
public class DistrictService {
    @Autowired
    private DistrictRepository districtImplement;
    
    
    public Iterable<District> getAllDistrict(){
        return districtImplement.getAll();
    }
}
