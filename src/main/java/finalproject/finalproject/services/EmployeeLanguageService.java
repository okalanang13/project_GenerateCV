/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.services;

import finalproject.finalproject.entities.EmployeeLanguage;
import finalproject.finalproject.repositories.EmployeeLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RR17
 */
@Service
public class EmployeeLanguageService {
    @Autowired
    private EmployeeLanguageRepository empLaImplement;
    
    public Iterable<EmployeeLanguage> getAllEmpla(){
        return empLaImplement.getAll();
    }
}
