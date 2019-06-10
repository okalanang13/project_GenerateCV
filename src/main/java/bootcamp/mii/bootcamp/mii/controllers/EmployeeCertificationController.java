/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.controllers;

import bootcamp.mii.bootcamp.mii.entities.EmployeeCertification;
import bootcamp.mii.bootcamp.mii.entities.EmployeeTraining;
import bootcamp.mii.bootcamp.mii.repositories.EmployeeCertificationRepository;
import bootcamp.mii.bootcamp.mii.services.CertificationService;
import bootcamp.mii.bootcamp.mii.services.EmployeeService;
import bootcamp.mii.bootcamp.mii.services.EnployeeCertificationService;
import bootcamp.mii.bootcamp.mii.services.TrainingService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ASUS
 */
@Controller
public class EmployeeCertificationController {
     @Autowired
    private EnployeeCertificationService employeeCertificationService;

    @Autowired
    private EmployeeCertificationRepository employeeCertificationRepository;
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private CertificationService certificationService;

    @GetMapping("/employeecertification")
    public String employeecertification(Model model) {
        model.addAttribute("dataEC", employeeCertificationService.findAllEmployeeCertification());
        model.addAttribute("dataEmployee", employeeService.findAllEmployee());
        model.addAttribute("dataCertification", certificationService.findAllCertification());
        return "employeecertification";
        
    }

    @PostMapping("/addemployeecertification")

    public String addemployeecertification(@Valid EmployeeCertification employee) {
        employee.setId(0);
        employee.setIsDelete('0');
        employeeCertificationRepository.save(employee);
        return "redirect:/employeecertification";

    }

    @PostMapping("/updateemployeecertification")

    public String updateemployeecertification(@Valid EmployeeCertification e ) {
        e.setIsDelete('0');
        employeeCertificationRepository.save(e);
        return "redirect:/employeecertification";

    }
    
     @GetMapping("/deleteemployeecertification")

    public String deleteemployeecertification(@Valid EmployeeCertification e) {
        e.setIsDelete('1');
        employeeCertificationRepository.save(e);
        return "redirect:/employeecertification";

    }
}
