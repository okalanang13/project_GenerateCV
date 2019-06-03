package bootcamp.mii.bootcamp.mii.services;

import bootcamp.mii.bootcamp.mii.entities.Province;
import bootcamp.mii.bootcamp.mii.repositories.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RR17
 */
@Repository
public class ProvinceService {
    @Autowired
    private ProvinceRepository provinceImplement;
    
    
    public Iterable<Province> findAllProvince(){
        return provinceImplement.findAll();
    }
    
}
