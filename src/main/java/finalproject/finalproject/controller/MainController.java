/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.controller;

import finalproject.finalproject.repositories.EmployeeRepository;
import finalproject.finalproject.repositories.ReligionRepository;
import finalproject.finalproject.repositories.VillageRepository;
import finalproject.finalproject.services.EmployeeService;
import finalproject.finalproject.services.ReligionService;
import finalproject.finalproject.services.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ASUS
 */
@Controller
public class MainController {
    @Autowired
    private ReligionService religionService;
    
    @Autowired
    private ReligionRepository religionRepository;
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private VillageService villageService;
    
    @Autowired
    private VillageRepository villageRepository;
  

//    @GetMapping("/")
//    public String index(Model model) {
//        model.addAttribute("dataReligion", religionService.findAllReligion());
//        return "index";
//    }
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("dataEmployee", employeeService.findAllEmployee());
        return "index";
    }
}
