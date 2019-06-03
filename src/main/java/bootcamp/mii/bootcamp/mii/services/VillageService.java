package bootcamp.mii.bootcamp.mii.services;

import bootcamp.mii.bootcamp.mii.entities.Village;
import bootcamp.mii.bootcamp.mii.repositories.VillageRepository;
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
