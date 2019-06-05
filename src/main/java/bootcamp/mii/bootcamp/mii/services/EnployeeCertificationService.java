/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.services;

import bootcamp.mii.bootcamp.mii.entities.EmployeeCertification;
import bootcamp.mii.bootcamp.mii.repositories.EmployeeCertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class EnployeeCertificationService {
    @Autowired
    private EmployeeCertificationRepository employeeCertificationRepository;
    
    public Iterable<EmployeeCertification> findAllEmployeeCertification(){
        return employeeCertificationRepository.findAll();
    }
}
