package finalproject.finalproject.services;

import finalproject.finalproject.entities.Education;
import finalproject.finalproject.repositories.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RR17
 */
@Service
public class EducationService {
    @Autowired
    private EducationRepository educationImplement;
    
    public Iterable<Education> getAllEducation(){
        return educationImplement.getAll();
    }
}
