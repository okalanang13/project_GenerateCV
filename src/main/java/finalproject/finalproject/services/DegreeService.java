/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.services;

import finalproject.finalproject.entities.Degree;
import finalproject.finalproject.repositories.DegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RR17
 */
@Service
public class DegreeService {
    @Autowired
    private DegreeRepository degreeImplement;
    
    public Iterable<Degree> findAllDegree(){
        return degreeImplement.findAll();
    }
}
