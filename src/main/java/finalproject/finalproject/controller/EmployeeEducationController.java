/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.controller;

import finalproject.finalproject.entities.EmployeeEducation;
import finalproject.finalproject.repositories.EmployeeEducationRepository;
import finalproject.finalproject.services.EmployeeEducationService;
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
public class EmployeeEducationController {
    //tidak perlu lagi menyediakan setter method maupun menambahkan argumen di constructor. 
    //Kita dapat menggunakan anotasi @Autowired
    @Autowired
    private EmployeeEducationRepository employeeEducationRepository;
    
    @Autowired
    private EmployeeEducationService employeeEducationService;
    
    //@GetMapping adalah anotasi tersusun yang berfungsi sebagai pintasan untuk 
    //@RequestMapping(method = RequestMethod.GET).
    //proses menampilkan semua data actor
    @GetMapping("/page/employeeEducation")
    public String employeeEducation(Model model) {
        model.addAttribute("dataEmployeeEducation", employeeEducationService.getAllEmpEd());
        return "employeeEducation";
    }
    
    @PostMapping("/page/employeeEducation/addDataEmped")
    public String addDataEmped (@Valid EmployeeEducation employeeEducation){
        employeeEducationRepository.save(employeeEducation);
        return "redirect:/page/employeeEducation";
    }
}