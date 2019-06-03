package bootcamp.mii.bootcamp.mii.services;


import bootcamp.mii.bootcamp.mii.entities.Subdistrict;
import bootcamp.mii.bootcamp.mii.repositories.SubdistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RR17
 */
@Service
public class SubdistrictService {
    @Autowired
    private SubdistrictRepository subdistrictImplement;
    
    
    public Iterable<Subdistrict> findAllSubdistrict(){
        return subdistrictImplement.findAll();
    }
}
