package finalproject.finalproject.services;

import finalproject.finalproject.entities.Job;
import finalproject.finalproject.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RR17
 */
@Service
public class JobService {
    @Autowired
    private JobRepository jobImplement;
    
    public Iterable<Job> getAllJob(){
        return jobImplement.getAll();
    }
}
