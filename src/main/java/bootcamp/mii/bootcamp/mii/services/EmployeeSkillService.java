/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.services;

import bootcamp.mii.bootcamp.mii.entities.EmployeeSkill;
import bootcamp.mii.bootcamp.mii.repositories.EmployeeSkillRepository;
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
