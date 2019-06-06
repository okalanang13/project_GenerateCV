package finalproject.finalproject.services;

import finalproject.finalproject.entities.Province;
import finalproject.finalproject.repositories.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RR17
 */
@Service
public class ProvinceService {
    @Autowired
    private ProvinceRepository provinceImplement;
    
    public Iterable<Province> getAllProvince(){
        return provinceImplement.getAll();
    }
    
}
