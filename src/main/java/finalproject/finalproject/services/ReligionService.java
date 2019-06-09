/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.services;

import finalproject.finalproject.entities.Religion;
import finalproject.finalproject.repositories.ReligionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */

@Service
public class ReligionService {
    
    @Autowired
    private ReligionRepository religionImplement;
    
    
    public Iterable<Religion> getAllReligion(){
        return religionImplement.getAll();
    }
}
