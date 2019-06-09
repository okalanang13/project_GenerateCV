/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.services;

import finalproject.finalproject.entities.EmployeeEducation;
import finalproject.finalproject.repositories.EmployeeEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RR17
 */
@Service
public class EmployeeEducationService {
    @Autowired
    private EmployeeEducationRepository empEdImplement;
    
    public Iterable<EmployeeEducation> getAllEmpEd(){
        return empEdImplement.getAll();
    }
}
