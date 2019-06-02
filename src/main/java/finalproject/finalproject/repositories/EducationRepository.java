/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.repositories;

import finalproject.finalproject.entities.Education;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RR17
 */
@Repository
public interface EducationRepository extends CrudRepository<Education, String>{
    
}
