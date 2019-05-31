package finalproject.finalproject.services;

import finalproject.finalproject.entities.Province;
import finalproject.finalproject.repositories.ProvinceRepository;
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
