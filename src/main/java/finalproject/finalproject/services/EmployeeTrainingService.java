/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.services;

import finalproject.finalproject.entities.EmployeeTraining;
import finalproject.finalproject.repositories.EmployeeTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class EmployeeTrainingService {
    @Autowired
    private EmployeeTrainingRepository employeeTrainingRepository;
    
    public  Iterable<EmployeeTraining> findAllEmployeeTraining(){
        return employeeTrainingRepository.findAll();
    }
}
