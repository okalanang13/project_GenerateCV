/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.services;

import finalproject.finalproject.entities.EmployeeSkill;
import finalproject.finalproject.repositories.EmployeeRepository;
import finalproject.finalproject.repositories.EmployeeSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class EmployeeSkillService {
    @Autowired
    private EmployeeSkillRepository employeeRepository;
    
    public Iterable<EmployeeSkill> findAllEmployeeSkill(){
        return employeeRepository.findAll();
    }
}
