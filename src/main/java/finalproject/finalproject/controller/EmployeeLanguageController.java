/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.controller;

import finalproject.finalproject.entities.EmployeeLanguage;
import finalproject.finalproject.repositories.EmployeeLanguageRepository;
import finalproject.finalproject.services.EmployeeLanguageService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author RR17
 */
@Controller
public class EmployeeLanguageController {
    //tidak perlu lagi menyediakan setter method maupun menambahkan argumen di constructor. 
    //Kita dapat menggunakan anotasi @Autowired
    @Autowired
    private EmployeeLanguageRepository employeeLanguageRepository;
    
    @Autowired
    private EmployeeLanguageService employeeLanguageService;
    
    //@GetMapping adalah anotasi tersusun yang berfungsi sebagai pintasan untuk 
    //@RequestMapping(method = RequestMethod.GET).
    //proses menampilkan semua data actor
    @GetMapping("/page/employeeLanguage")
    public String employeeLanguage(Model model) {
        model.addAttribute("dataEmpla", employeeLanguageService.getAllEmpla());
        return "employeeLanguage";
    }
    
    @PostMapping("/page/employeeLanguage/addDataEmpla")
    public String addDataEmpla (@Valid EmployeeLanguage employeeLanguage){
        employeeLanguageRepository.save(employeeLanguage);
        return "redirect:/page/employeeLanguage";
    }
}
