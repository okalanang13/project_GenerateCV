package finalproject.finalproject.services;

import finalproject.finalproject.entities.College;
import finalproject.finalproject.repositories.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RR17
 */
@Service
public class CollegeService {
    @Autowired
    private CollegeRepository collegeImplement;
    
    public Iterable<College> findAllCollege(){
        return collegeImplement.findAll();
    }
}
