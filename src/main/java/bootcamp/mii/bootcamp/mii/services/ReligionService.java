/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.services;


import bootcamp.mii.bootcamp.mii.entities.Religion;
import bootcamp.mii.bootcamp.mii.repositories.ReligionRepository;
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
    
    
    public Iterable<Religion> findAllReligion(){
        return religionImplement.findAll();
    }
}
