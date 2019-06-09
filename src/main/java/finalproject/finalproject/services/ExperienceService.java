package finalproject.finalproject.services;

import finalproject.finalproject.entities.Experience;
import finalproject.finalproject.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RR17
 */
@Service
public class ExperienceService {
    @Autowired
    private ExperienceRepository experienceImplement;
    
    public Iterable<Experience> getAllExperience(){
        return experienceImplement.getAll();
    }
}
