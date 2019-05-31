package finalproject.finalproject.services;

import finalproject.finalproject.entities.Subdistrict;
import finalproject.finalproject.repositories.SubdistrictRepository;
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
