package finalproject.finalproject.services;

import finalproject.finalproject.entities.Village;
import finalproject.finalproject.repositories.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RR17
 */
@Service
public class VillageService {
    @Autowired
    private VillageRepository villageImplement;
    
    
    public Iterable<Village> findAllVillage(){
        return villageImplement.findAll();
    }
}
